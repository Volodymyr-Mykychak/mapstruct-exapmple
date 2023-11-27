package mate.academy.mapstructexapmple.service.employee;

import java.util.List;
import mate.academy.mapstructexapmple.dto.employee.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.employee.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(CreateEmployeeRequestDto requestDto);

    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    List<EmployeeDto> getAllByName(String name);
}
