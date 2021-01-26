package com.demo.service;

import com.demo.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyService extends JpaRepository<Property, Integer>{
}
