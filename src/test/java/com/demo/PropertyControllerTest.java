package com.demo;

import com.demo.model.Property;
import com.demo.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PropertyService propertyService;

    @Test
    public void testGetDepartment() throws Exception {
        Property employee = new Property();
        employee.setId(1);

        List<Property> employeeList = new ArrayList<>();
        employeeList.add(employee);

        given(propertyService.findAll()).willReturn(employeeList);

        this.mockMvc.perform(get("/properties")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
    }

}
