package mate.academy.mapstructexapmple.mapper;

import mate.academy.mapstructexapmple.dto.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.EmployeeDto;
import mate.academy.mapstructexapmple.model.Department;
import mate.academy.mapstructexapmple.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
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

        employee.setDepartment(new Department(requestDto.departmentId()));
        return employee;
    }
}
