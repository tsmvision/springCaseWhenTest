package com.example.springcasewhentest.repository;

import com.example.springcasewhentest.dto.EmployeeProjectionDto;
import static com.example.springcasewhentest.entity.QEmployee.employee;
import static com.example.springcasewhentest.entity.QDepartment.department;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<EmployeeProjectionDto> findWithDepartment() {
        NumberExpression<Integer> isDepartmentNameTraining = isDepartmentNameTraining();
        return queryFactory
                .from(employee)
                .select(
                        Projections.constructor(
                                EmployeeProjectionDto.class,
                                employee.id,
                                employee.firstName,
                                employee.lastName,
                                department.id,
                                department.name,
                                isDepartmentNameTraining
                        )
                )
                .join(employee.department, department)
                .groupBy(
                        employee.id,
                        employee.firstName,
                        employee.lastName,
                        department.id,
                        department.name,
                        isDepartmentNameTraining
                )
                .orderBy(isDepartmentNameTraining.asc(), employee.firstName.desc())
                .fetch();
    }

    private NumberExpression<Integer> isDepartmentNameTraining() {
        return new CaseBuilder()
                .when(department.id.eq(1L))
                .then(1)
                .otherwise(0);
    }
}
