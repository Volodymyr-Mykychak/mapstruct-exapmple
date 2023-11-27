package mate.academy.mapstructexapmple.mapper;

import java.util.List;
import mate.academy.mapstructexapmple.config.MapperConfig;
import mate.academy.mapstructexapmple.dto.employee.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.employee.EmployeeDto;
import mate.academy.mapstructexapmple.dto.employee.EmployeeWithoutSkillsDto;
import mate.academy.mapstructexapmple.model.Department;
import mate.academy.mapstructexapmple.model.Employee;
import mate.academy.mapstructexapmple.model.Skill;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class, uses = DepartmentMapper.class)
public interface EmployeeMapper {
    @Mapping(source = "department", target = "departmentId", qualifiedByName = "mapDepartmentToId")
    @Mapping(target = "skillIds", ignore = true)
    EmployeeDto toDto(Employee employee);

    @Named("mapDepartmentToId")
    default Long mapDepartmentToId(Department department) {
        return department == null ? null : department.getId();
    }

    @AfterMapping
    default void setSkillIds(@MappingTarget EmployeeDto employeeDto, Employee employee) {
        List<Long> skillIds = employee.getSkills().stream()
                .map(Skill::getId)
                .toList();
        employeeDto.setSkillIds(skillIds);
    }

    @Mapping(source = "department", target = "department", qualifiedByName = "mapDepartmentToId")
    EmployeeWithoutSkillsDto toEmployeeWithoutSkillsDto(Employee employee);

    @Mapping(target = "department", source = "departmentId",
            qualifiedByName = "departmentById")
    @Mapping(target = "skills", ignore = true)
    Employee toModel(CreateEmployeeRequestDto requestDto);

    @AfterMapping
    default void setSkills(@MappingTarget Employee employee, CreateEmployeeRequestDto requestDto) {
        List<Skill> skills = requestDto.skills().stream()
                .map(Skill::new)
                .toList();
        employee.setSkills(skills);
    }
}
