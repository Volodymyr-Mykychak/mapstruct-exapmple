package mate.academy.mapstructexapmple.mapper;

import mate.academy.mapstructexapmple.config.MapperConfig;
import mate.academy.mapstructexapmple.dto.CreateDepartmentRequestDto;
import mate.academy.mapstructexapmple.dto.DepartmentDto;
import mate.academy.mapstructexapmple.model.Department;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface DepartmentMapper {
    DepartmentDto toDto(Department department);

    Department toModel(CreateDepartmentRequestDto requestDto);
}
