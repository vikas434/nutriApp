package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import co.rivatech.nutrition.constatnts.DateUtil;
import co.rivatech.nutrition.dto.Children;
import co.rivatech.nutrition.dto.ConfigSource;
import co.rivatech.nutrition.dto.Configs;
import co.rivatech.nutrition.dto.DistrictMaps;
import co.rivatech.nutrition.dto.FamilyDetails;
import co.rivatech.nutrition.dto.Finance;
import co.rivatech.nutrition.dto.Location;
import co.rivatech.nutrition.dto.Occupation;
import co.rivatech.nutrition.dto.Women;
import co.rivatech.nutrition.enums.Entity;
import co.rivatech.nutrition.exception.MobileAlreadyExistsException;
import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.model.ChildDetails;
import co.rivatech.nutrition.model.Family;
import co.rivatech.nutrition.model.FinancialDetails;
import co.rivatech.nutrition.model.LocationDetails;
import co.rivatech.nutrition.model.OccupationDetails;
import co.rivatech.nutrition.model.Woman;
import co.rivatech.nutrition.model.WomanDetailsWithFamilyName;
import co.rivatech.nutrition.repository.FamilyRepository;
import co.rivatech.nutrition.repository.ShortNameMapRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Slf4j
@Service
public class FamilyService {

    private static final String SEPERATOR = "-";

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private ShortNameMapRepository shortNameMapRepository;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private PanchayatService panchayatService;

    @Autowired
    private VillageService villageService;

    @Autowired
    private TolaService tolaService;

    @Autowired
    private ChildService childService;

    @Autowired
    private WomanService womanService;

    @Autowired
    private LocationDetailsService locationDetailsService;

    @Autowired
    private OccupationDetailsService occupationDetailsService;

    @Autowired
    private FinancialDetailsService financialDetailsService;

    public Family addFamily(final Family family) {
        validateFamilyData(family);
        family.setFamilyId(getShortId(family.getDetails()));
        final Family savedData = familyRepository.save(family);
        //TODO check why family id is not in increasing order.
        saveOtherDetailsAsync(savedData.getDetails(), savedData.getId());
        return savedData;
    }

    @Async
    protected void saveOtherDetailsAsync(final FamilyDetails details, final int familyId) {
        final List<Children> childrenList = details.getChildrenList();
        if (!CollectionUtils.isEmpty(childrenList)) {
            final List<Child> children = new ArrayList<>();
            childrenList.forEach(c -> {
                final Child child = new Child();
                child.setFamilyId(familyId);
                child.setName(c.getName());
                child.setNameHindi(c.getNameHindi());
                child.setTolaId(1);//TODO get the tola id.
                children.add(child);
            });
            childService.addAllChild(children);
        }

        final List<Women> womanList = details.getWomenList();
        if (!CollectionUtils.isEmpty(womanList)) {
            final List<Woman> women = new ArrayList<>();
            womanList.forEach(w -> {
                final Woman woman = new Woman();
                woman.setFamilyId(familyId);
                woman.setName(w.getName());
                woman.setNameHindi(w.getNameHindi());
                woman.setCreatedAt(new Date());
                women.add(woman);
            });
            womanService.addAllWomen(women);
        }

        final Location location = details.getLocation();
        if (Objects.nonNull(location)) {
            final LocationDetails locationDetails = new LocationDetails();
            locationDetails.setDetails(location);
            locationDetails.setFamilyId(familyId);
            locationDetails.setCreatedAt(new Date());
            locationDetailsService.save(locationDetails);
        }

        final Occupation occupation = details.getOccupation();
        if (Objects.nonNull(occupation)) {
            final OccupationDetails occupationDetails = new OccupationDetails();
            occupationDetails.setFamilyId(familyId);
            occupationDetails.setDetails(occupation);
            occupationDetails.setCreatedAt(new Date());
            occupationDetailsService.save(occupationDetails);
        }

        final Finance finance = details.getFinance();
        if (Objects.nonNull(finance)) {
            final FinancialDetails financialDetails = new FinancialDetails();
            financialDetails.setFamilyId(familyId);
            financialDetails.setDetails(finance);
            financialDetails.setCreatedAt(new Date());
            financialDetailsService.save(financialDetails);
        }
        log.info("Other details saved for family id {}", familyId);
    }

    private String getShortId(final FamilyDetails details) {
        final Map<Entity, Map<Integer, String>> shortMap = shortNameMapRepository.getShortNameMap();
        final String district = shortMap.get(Entity.DISTRICT).get(details.getDistrictId());
        final String block = shortMap.get(Entity.BLOCK).get(details.getBlockId());
        final String panchayat = shortMap.get(Entity.PANCHAYAT).get(details.getPanchayatId());
        final String village = shortMap.get(Entity.VILLAGE).get(details.getVillageId());
        final int id = familyRepository.findTopByOrderByIdDesc().orElseGet(Family::new).getId() + 1;
        log.info("District {} Block {} Panchayat {} Village {} and Id {}", district, block, panchayat, village, id);
        return district +
                SEPERATOR +
                block +
                SEPERATOR +
                panchayat +
                SEPERATOR +
                village +
                SEPERATOR +
                id;
    }

    private void validateFamilyData(final Family family) { //NOPMD
        final BigInteger mobile = family.getMobile();
        if (familyRepository.findByMobile(mobile).isPresent()) {
            throw new MobileAlreadyExistsException(String.format("Mobile entry exists with this number %s", mobile));
        }
        Assert.notNull(family.getDetails(), "Family details not shared.");
        Assert.isTrue(family.getDetails().getTotalMembers() >= family.getDetails()
                                                                     .getTotalChildren() + family.getDetails()
                                                                                                 .getTotalWomen(),
                      "Total family size mismatch.");
    }

    public Family checkMobileNumber(final BigInteger mobile) {
        return familyRepository.findByMobile(mobile)
                               .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                       "No Family details found with mobile %s ",
                                       mobile)));
    }

    public Family getFamilyDetailsById(final int familyId) {
        return familyRepository.findById(familyId)
                               .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                       "No Family details found with familyId %s ",
                                       familyId)));

    }

    public Configs getAllConfigs() {
        return Configs.builder()
                      .casteConfig(ConfigSource.getCasteList())
                      .religionConfig(ConfigSource.getReligionList())
                      .sexConfig(ConfigSource.getSexList())
                      .rationConfig(ConfigSource.getRationColorList())
                      .workLocationConfig(ConfigSource.workLocationList())
                      .workDurationConfig(ConfigSource.workDurationList())
                      .memberWorkingOutConfig(ConfigSource.MemberWorkingOutList())
                      .placeOfBirthConfig(ConfigSource.PlaceOfBirthList())
                      .deliveryTypeConfig(ConfigSource.DeliveryTypeList())
                      .firstWaterConfig(ConfigSource.FirstWaterList())
                      .firstWaterReasonConfig(ConfigSource.FirstWaterReasonList())
                      .firstFoodConfig(ConfigSource.FirstFoodList())
                      .vaccinationConfig(ConfigSource.VaccinationsList())
                      .motherEducationConfig(ConfigSource.MotherEducationList())
                      .motherMaritalStatusConfig(ConfigSource.MotherMaritalStatusList())
                      .motherFirstFoodToKid(ConfigSource.MotherFirstFoodToKidList())
                      .motherFirstBreastFeeding(ConfigSource.MotherFirstBreastFeedingList())
                      .districts(districtService.getAllDistricts())
                      .blocks(blockService.getAllBlocks())
                      .panchayats(panchayatService.getAllPanchayats())
                      .villages(villageService.getAllVillages())
                      .tolas(tolaService.getAllTola())
                      .build();
    }

    public DistrictMaps getAllDistrictData() {
        final DistrictMaps maps = new DistrictMaps();
        maps.setDistricts(districtService.getAllDistricts());
        maps.setBlocks(blockService.getAllBlocks());
        maps.setPanchayats(panchayatService.getAllPanchayats());
        maps.setVillages(villageService.getAllVillages());
        maps.setTolas(tolaService.getAllTola());
        return maps;
    }

    public Family getFamilyDetailsByFullFamilyId(final String fullFamilyId) {
        final Family familyFullDetails = familyRepository.findByFamilyId(fullFamilyId)
                                                         .orElseThrow(() -> new ResourceNotFoundException(
                                                                 String.format(
                                                                         "No Family details found with full familyId %s ",
                                                                         fullFamilyId)));
        final int familyId = familyFullDetails.getId();
        final List<ChildDetails> childDetails = childService.findByFamilyId(familyId);
        childDetails.forEach(c -> {
            c.setFullFamilyId(fullFamilyId);
            c.setDobFormatted(DateUtil.getFormat().format(c.getChildDetailsJson().getDob()));
        });
        familyFullDetails.setChildFullDetailsJson(childDetails);

        final List<WomanDetailsWithFamilyName> womanDetails = womanService.getWomanDetailsByFamilyId(familyId);
        womanDetails.forEach(w -> {
            w.setFullFamilyId(fullFamilyId);
            w.setDobFormatted(DateUtil.getFormat().format(w.getWomanDetailsJson().getDob()));
        });
        familyFullDetails.setWomanFullDetailsJson(womanDetails);

        return familyFullDetails;
    }

    public List<Family> getFamilyDetailsByFamilyHeadHindi(final String familyHead) {
        return familyRepository.findByNameHindiContaining(familyHead);
    }

    public List<Family> getFamilyDetailsByFamilyHead(final String familyHead) {
        return familyRepository.findByNameContaining(familyHead);
    }

    public Page<Family> findAll(final Pageable paging, Integer villageId) {
        Page<Family> families = familyRepository.findAll(paging);
        final List<Family> familyList = new ArrayList<>();
        if (Objects.nonNull(villageId)) {
            families.get()
                    .filter(f -> f.getDetails().getVillageId() == villageId)
                    .collect(Collectors.toList());
            return new PageImpl<>(familyList);
        }

        return families;
    }

    public void deleteById(final int familyId) {
        familyRepository.deleteById(familyId);
    }

    public Family updateFamily(final Family family) {
        family.setUpdatedAt(new Date());
        familyRepository.save(family);
        saveOtherDetailsAsyncWithId(family.getDetails(), family.getId());
        return family;
    }

    @Async
    protected void saveOtherDetailsAsyncWithId(final FamilyDetails details, final int familyId) {
        //TODO check if change in woman and child name needed.

        final LocationDetails locationDetails = locationDetailsService.getLocationByFamilyId(familyId);
        locationDetails.setDetails(details.getLocation());
        locationDetails.setUpdatedAt(new Date());
        locationDetailsService.save(locationDetails);

        final OccupationDetails occupationDetails = occupationDetailsService.getOccupationByFamilyId(familyId);
        occupationDetails.setDetails(details.getOccupation());
        occupationDetails.setUpdatedAt(new Date());
        occupationDetailsService.save(occupationDetails);

        final FinancialDetails financialDetails = financialDetailsService.getFinancialDetailsByFamilyId(familyId);
        financialDetails.setDetails(details.getFinance());
        financialDetails.setUpdatedAt(new Date());
        financialDetailsService.save(financialDetails);
    }
}
