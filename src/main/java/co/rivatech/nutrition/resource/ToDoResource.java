package co.rivatech.nutrition.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import co.rivatech.nutrition.dto.ToDo;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/todo")
public class ToDoResource {



    @GetMapping("/getTodo")
    @ApiOperation(value = "[WIP] get todays to do list.")
    public List<ToDo> getTodoList(@RequestParam(defaultValue = "0") Integer pageNo,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        //TODO get LMS data
        return Collections.EMPTY_LIST;
    }




}
