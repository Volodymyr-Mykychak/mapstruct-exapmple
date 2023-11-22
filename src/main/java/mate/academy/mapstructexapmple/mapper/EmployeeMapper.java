package mate.academy.mapstructexapmple.mapper;

import mate.academy.mapstructexapmple.dto.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.EmployeeDto;
import mate.academy.mapstructexapmple.model.Employee;

public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);

    Employee toModel(CreateEmployeeRequestDto requestDto);
}
