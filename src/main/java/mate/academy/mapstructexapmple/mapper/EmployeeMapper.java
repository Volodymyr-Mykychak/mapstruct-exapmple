package mate.academy.mapstructexapmple.mapper;

import mate.academy.mapstructexapmple.config.MapperConfig;
import mate.academy.mapstructexapmple.dto.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.EmployeeDto;
import mate.academy.mapstructexapmple.model.Employee;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);

    Employee toModel(CreateEmployeeRequestDto requestDto);
}
