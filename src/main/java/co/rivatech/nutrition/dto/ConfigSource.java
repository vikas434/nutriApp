package co.rivatech.nutrition.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.rivatech.nutrition.enums.Caste;
import co.rivatech.nutrition.enums.DeliveryType;
import co.rivatech.nutrition.enums.FirstFood;
import co.rivatech.nutrition.enums.FirstWater;
import co.rivatech.nutrition.enums.FirstWaterReason;
import co.rivatech.nutrition.enums.MotherChildBreastFeeding;
import co.rivatech.nutrition.enums.MotherChildFirstFood;
import co.rivatech.nutrition.enums.MotherMaritalStatus;
import co.rivatech.nutrition.enums.MemberWorkingOut;
import co.rivatech.nutrition.enums.MotherHigherEducation;
import co.rivatech.nutrition.enums.PlaceOfBirth;
import co.rivatech.nutrition.enums.RationColor;
import co.rivatech.nutrition.enums.Religion;
import co.rivatech.nutrition.enums.Sex;
import co.rivatech.nutrition.enums.Vaccination;
import co.rivatech.nutrition.enums.WorkDuration;
import co.rivatech.nutrition.enums.WorkLocation;
import lombok.Data;

/**
 * @author vranjan
 * created 08/09/2021
 */
@Data
public class ConfigSource {

    //TODO simiplify all the configs in to one.
    public static List<GeneralConfig> getCasteList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(Caste.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), Caste.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getReligionList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(Religion.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), Religion.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getSexList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(Sex.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), Sex.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> getRationColorList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(RationColor.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), RationColor.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> workLocationList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(WorkLocation.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), WorkLocation.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> workDurationList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(WorkDuration.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), WorkDuration.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> MemberWorkingOutList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(MemberWorkingOut.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), MemberWorkingOut.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> PlaceOfBirthList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(PlaceOfBirth.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), PlaceOfBirth.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> DeliveryTypeList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(DeliveryType.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), DeliveryType.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> FirstWaterList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(FirstWater.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), FirstWater.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> FirstWaterReasonList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(FirstWaterReason.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), FirstWaterReason.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> FirstFoodList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(FirstFood.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), FirstFood.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> VaccinationsList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(Vaccination.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), Vaccination.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> MotherEducationList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(MotherHigherEducation.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), MotherHigherEducation.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> MotherMaritalStatusList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(MotherMaritalStatus.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), MotherMaritalStatus.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> MotherFirstFoodToKidList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(MotherChildFirstFood.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), MotherChildFirstFood.valueOf(c)));
        });
        return generalConfigs;
    }

    public static List<GeneralConfig> MotherFirstBreastFeedingList() {
        final List<GeneralConfig> generalConfigs = new ArrayList<>();
        Arrays.stream(MotherChildBreastFeeding.values()).forEach(c -> {
            generalConfigs.add(new GeneralConfig(c.name(), MotherChildBreastFeeding.valueOf(c)));
        });
        return generalConfigs;
    }
}
