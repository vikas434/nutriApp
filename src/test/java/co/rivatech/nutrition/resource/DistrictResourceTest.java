package co.rivatech.nutrition.resource;

import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import co.rivatech.nutrition.constatnts.JsonUtil;
import co.rivatech.nutrition.model.District;
import co.rivatech.nutrition.repository.DistrictRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author vranjan
 * @created 29/07/2021
 */

@SpringBootTest
@AutoConfigureMockMvc
class DistrictResourceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private DistrictRepository repository;

    @After
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
    void whenValidInput_crateDistrict() throws Exception {
        District district = District.builder().name("Test").nameHindi("test").shortName("TE").build();
        mvc.perform(post("/v1/district/add").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(district)))
           .andExpect(status().is2xxSuccessful());
        Assertions.assertNotNull(repository.findAll());
    }
}