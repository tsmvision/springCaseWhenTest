package com.example.springcasewhentest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeProjectionDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String departmentName;
    private Long departmentId;
    private Integer isDepartmentNameTraining;

    public EmployeeProjectionDto(
            Long id,
            String firstName,
            String lastName,
            Long departmentId,
            String departmentName,
            Integer isDepartmentNameTraining
            ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.isDepartmentNameTraining = isDepartmentNameTraining;
    }
}
