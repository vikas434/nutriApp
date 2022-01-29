package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Tola;
import co.rivatech.nutrition.service.TolaService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 08/08/2021
 */
@RestController
@RequestMapping("/v1/tola")
public class TolaResource {

    //TODO TDD based validations and exceptions

    @Autowired
    private TolaService tolaService;

    @GetMapping("/")
    @ApiOperation(value = "Get lists of all the tolas.")
    public List<Tola> getAllVillages() {
        return tolaService.getAllTola();
    }

    @GetMapping("/findTolaByVillageId/{villageId}")
    @ApiOperation(value = "Get lists of all the tolas by villageId or throw exception")
    public List<Tola> getAllTolaByVillageId(@Nonnull @PathVariable int villageId) {
        return tolaService.getAllTolasByVillageId(villageId);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a tola.")
    public Tola addTola(@Nonnull @RequestBody Tola tola) {
        return tolaService.addTola(tola);
    }

}
