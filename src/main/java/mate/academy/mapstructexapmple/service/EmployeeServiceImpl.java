package mate.academy.mapstructexapmple.service;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.mapstructexapmple.dto.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.EmployeeDto;
import mate.academy.mapstructexapmple.exception.EntityNotFoundException;
import mate.academy.mapstructexapmple.mapper.EmployeeMapper;
import mate.academy.mapstructexapmple.model.Employee;
import mate.academy.mapstructexapmple.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto save(CreateEmployeeRequestDto requestDto) {
        Employee employee = employeeMapper.toModel(requestDto);
        employee.setSocialSecurityNumber("abc " + new Random().nextInt(1000));
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find by id " + id)
        );
        return employeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllByName(String name) {
        return employeeRepository.findAllByName(name).stream()
                .map(employeeMapper::toDto)
                .toList();
    }
}
