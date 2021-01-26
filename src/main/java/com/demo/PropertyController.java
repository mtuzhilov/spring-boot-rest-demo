package com.demo;

import com.demo.model.Property;
import com.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/property/{id}", method = RequestMethod.GET)
    Property getProperty(@PathVariable Integer id){
        return  propertyService.findById(id).get();
    }

    @RequestMapping(value = "/property", method = RequestMethod.POST)
    String addProperty(@RequestBody Property property){
        Property savedProperty = propertyService.save(property);
        return "SUCCESS";
    }

    @RequestMapping(value = "/property", method = RequestMethod.PUT)
    Property updateProperty(@RequestBody Property property){
        Property updatedProperty = propertyService.save(property);
        return updatedProperty;
    }

    @RequestMapping(value = "/property", method = RequestMethod.DELETE)
    Map<String, String> deleteProperty(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Optional<Property> property = propertyService.findById(id);
        if(property.isPresent()) {
            propertyService.delete(property.get());
            status.put("Status", "Property deleted successfully");
        }
        else {
            status.put("Status", "Property not exist");
        }
        return status;
    }

    // Select, Insert, Delete for List of Properties

    @RequestMapping(value = "/properties", method = RequestMethod.GET)
    List<Property> getAllProperty(){
        return propertyService.findAll();
    }

    @RequestMapping(value = "/properties", method = RequestMethod.POST)
    String addAllPropertys(@RequestBody List<Property> propertyList){
        propertyService.saveAll(propertyList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/properties", method = RequestMethod.DELETE)
    String addAllPropertys(){
        propertyService.deleteAll();
        return "SUCCESS";
    }
}
