package com.resource.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resource.server.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	ObjectMapper mapper;
	@RequestMapping(value="/get/EmpList")
	public String getEmplist() throws JsonProcessingException {
		Employee e1= new Employee();
		e1.setEmpId("1");
		e1.setEmpName("Tarun");
		String writeValueAsString = mapper.writeValueAsString(e1);
		return writeValueAsString;
	}
}
