package mate.academy.mapstructexapmple.service;

import java.util.List;
import mate.academy.mapstructexapmple.dto.CreateDepartmentRequestDto;
import mate.academy.mapstructexapmple.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto save(CreateDepartmentRequestDto requestDto);

    List<DepartmentDto> findAll();

    DepartmentDto findById(Long id);

    List<DepartmentDto> getAllByName(String name);
}
