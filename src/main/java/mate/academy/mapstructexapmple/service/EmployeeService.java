package mate.academy.mapstructexapmple.service;

import java.util.List;
import mate.academy.mapstructexapmple.dto.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(CreateEmployeeRequestDto requestDto);

    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    List<EmployeeDto> getAllByName(String name);
}
