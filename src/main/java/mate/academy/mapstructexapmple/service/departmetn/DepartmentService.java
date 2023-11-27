package mate.academy.mapstructexapmple.service.departmetn;

import java.util.List;
import mate.academy.mapstructexapmple.dto.department.CreateDepartmentRequestDto;
import mate.academy.mapstructexapmple.dto.department.DepartmentDto;

public interface DepartmentService {
    DepartmentDto save(CreateDepartmentRequestDto requestDto);

    List<DepartmentDto> findAll();

    DepartmentDto findById(Long id);

    List<DepartmentDto> getAllByName(String name);
}
