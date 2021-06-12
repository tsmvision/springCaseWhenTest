package com.example.springcasewhentest.controller;

import com.example.springcasewhentest.dto.EmployeeProjectionDto;
import com.example.springcasewhentest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeeProjectionDto> GetTest() {

        return employeeRepository.findWithDepartment();
    }
}
