package com.demo;

import com.demo.model.Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PropertyControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testEmployee()
    {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/property/1", Property.class)
                        .getId().equals(1));
    }

    @Test
    public void testAllEmployee() {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/properties", List.class).size() == 2);
    }
}

