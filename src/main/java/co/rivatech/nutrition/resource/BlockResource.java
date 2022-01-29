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

import co.rivatech.nutrition.model.Block;
import co.rivatech.nutrition.model.User;
import co.rivatech.nutrition.service.BlockService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 08/08/2021
 */
@RestController
@RequestMapping("/v1/block")
public class BlockResource {

    //TODO TDD based validations and exceptions

    @Autowired
    private BlockService blockService;

    @GetMapping("/")
    @ApiOperation(value = "Get lists of all the blocks.")
    public List<Block> getAllDistrict() {
        return blockService.getAllBlocks();
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Find the block details by id.",
                  notes = "Returns block else throws exception.")
    public Block getBlockById(@Nonnull @PathVariable int id) {
        return blockService.getBlockById(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a block")
    public ResponseEntity<Block> addDistrict(@Nonnull @RequestBody Block block) {
        return ResponseEntity.ok(blockService.addBlock(block));
    }

    @GetMapping("/findByDistrictId/{districtId}")
    @ApiOperation(value = "Find the block details by  district id.",
                  notes = "Returns List of block. else throws excpetion")
    public List<Block> getBlockByDistrictId(@Nonnull @PathVariable int districtId) {
        return blockService.getBlockByDistrictId(districtId);
    }

    @GetMapping("/anganwadiUsers/{blockId}")
    @ApiOperation(value = "Get list of all the anganwadi users, tied to that block. ")
    public List<User> getListOfAnganwadiUsersForBlock(@Nonnull @PathVariable int blockId) {
        return blockService.getAnganwadiUsersList(blockId);
    }

    @GetMapping("/surveyorUsers/{blockId}")
    @ApiOperation(value = "Get list of all the surveyor users, tied to that block. ")
    public List<User> getListOfSurveyorUsersForBlock(@Nonnull @PathVariable int blockId) {
        return blockService.getSurveyorList(blockId);
    }

}
