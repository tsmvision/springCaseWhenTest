package com.example.springcasewhentest.repository;

import com.example.springcasewhentest.dto.EmployeeProjectionDto;
import java.util.List;

public interface EmployeeRepositoryCustom {
    List<EmployeeProjectionDto> findWithDepartment();
}
