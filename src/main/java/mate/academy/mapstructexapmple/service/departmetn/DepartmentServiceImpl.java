package mate.academy.mapstructexapmple.service.departmetn;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.mapstructexapmple.dto.department.CreateDepartmentRequestDto;
import mate.academy.mapstructexapmple.dto.department.DepartmentDto;
import mate.academy.mapstructexapmple.exception.EntityNotFoundException;
import mate.academy.mapstructexapmple.mapper.DepartmentMapper;
import mate.academy.mapstructexapmple.model.Department;
import mate.academy.mapstructexapmple.repository.department.DepartmentRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto save(CreateDepartmentRequestDto requestDto) {
        Department department = departmentMapper.toModel(requestDto);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDto(savedDepartment);
    }

    @Override
    public List<DepartmentDto> findAll() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    @Override
    public DepartmentDto findById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find by id " + id)
        );
        return departmentMapper.toDto(department);
    }

    @Override
    public List<DepartmentDto> getAllByName(String name) {
        return departmentRepository.findAllByName(name).stream()
                .map(departmentMapper::toDto)
                .toList();
    }
}
