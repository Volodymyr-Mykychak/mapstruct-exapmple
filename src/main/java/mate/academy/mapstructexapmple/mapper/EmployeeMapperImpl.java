package mate.academy.mapstructexapmple.mapper;

import mate.academy.mapstructexapmple.dto.employee.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.employee.EmployeeDto;
import mate.academy.mapstructexapmple.dto.employee.EmployeeWithoutSkillsDto;
import mate.academy.mapstructexapmple.model.Employee;

public class EmployeeMapperImpl implements EmployeeMapper {
    private final DepartmentMapper departmentMapper;

    public EmployeeMapperImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        if (employee.getDepartment() != null) {
            employeeDto.setDepartmentId(employee.getDepartment().getId());
        }
        setSkillIds(employeeDto, employee);
        return employeeDto;
    }

    @Override
    public EmployeeWithoutSkillsDto toEmployeeWithoutSkillsDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeWithoutSkillsDto employeeDto = new EmployeeWithoutSkillsDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        if (employee.getDepartment() != null) {
            employeeDto.setDepartment(employee.getDepartment().getId());
        }
        return employeeDto;
    }

    @Override
    public Employee toModel(CreateEmployeeRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setName(requestDto.name());
        employee.setEmail(requestDto.email());
        employee.setDepartment(departmentMapper.departmentById(requestDto.departmentId()));
        setSkills(employee, requestDto);
        return employee;
    }
}
