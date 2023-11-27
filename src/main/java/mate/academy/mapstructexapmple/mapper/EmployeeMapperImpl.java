package mate.academy.mapstructexapmple.mapper;

import java.util.List;
import mate.academy.mapstructexapmple.dto.employee.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.employee.EmployeeDto;
import mate.academy.mapstructexapmple.model.Employee;
import mate.academy.mapstructexapmple.model.Skill;
import org.springframework.stereotype.Component;

@Component
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
        setSkills(requestDto.skills(), employee);
        return employee;
    }

    private void setSkills(List<Long> skillIds, Employee employee) {
        List<Skill> skills = skillIds.stream()
                .map(Skill::new)
                .toList();
        employee.setSkills(skills);

    }
}
