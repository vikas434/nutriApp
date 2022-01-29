package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Panchayat;
import co.rivatech.nutrition.service.PanchayatService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 08/08/2021
 */
@RestController
@RequestMapping("/v1/panchayat")
public class PanchayatResource {

    //TODO TDD based validations and exceptions

    @Autowired
    private PanchayatService panchayatService;

    @GetMapping("/")
    @ApiOperation(value = "Get lists of all the panchayats.")
    public List<Panchayat> getAllPanchayats() {
        return panchayatService.getAllPanchayats();
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Find the panchayat details by id.",
                  notes = "Returns  panchayat details by id or throw exception.")
    public Panchayat getBlockById(@Nonnull @PathVariable int id) {
        return panchayatService.getPanchayatById(id);
    }

    @GetMapping("/findAllByBlockId/{blockId}")
    @ApiOperation(value = "Find the panchayat details by block id.",
                  notes = "Returns panchayat. Null if not found.")
    public List<Panchayat> getPanchayatByBlockId(@Nonnull @PathVariable int blockId) {
        return panchayatService.findPanchayatByBlockId(blockId);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a Panchayat")
    public ResponseEntity<Panchayat> addDistrict(@Nonnull @RequestBody Panchayat panchayat) {
        return ResponseEntity.ok(panchayatService.addPanchayat(panchayat));
    }

}
