package mate.academy.mapstructexapmple.mapper;

import mate.academy.mapstructexapmple.dto.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.EmployeeDto;
import mate.academy.mapstructexapmple.model.Employee;

public class EmployeeMapperImpl implements EmployeeMapper {
    private final DepartmentMapper departmentMapper;

    public EmployeeMapperImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public EmployeeDto toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }

    public Employee toModel(CreateEmployeeRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setName(requestDto.name());
        employee.setEmail(requestDto.email());
        employee.setDepartment(departmentMapper.departmentById(requestDto.departmentId()));
        return employee;
    }
}
