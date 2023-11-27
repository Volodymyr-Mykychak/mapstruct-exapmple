package mate.academy.mapstructexapmple.mapper;

import mate.academy.mapstructexapmple.dto.employee.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.employee.EmployeeDto;
import mate.academy.mapstructexapmple.model.Employee;
import org.mapstruct.Mapping;

public interface EmployeeMapper {
    @Mapping(source = "department.id", target = "departmentId")
    EmployeeDto toDto(Employee employee);

    @Mapping(target = "department", source = "departmentId",
            qualifiedByName = "departmentById")
    Employee toModel(CreateEmployeeRequestDto requestDto);
}
