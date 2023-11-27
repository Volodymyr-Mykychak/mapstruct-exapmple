package mate.academy.mapstructexapmple.repository.department;

import java.util.List;
import java.util.Optional;
import mate.academy.mapstructexapmple.model.Department;

public interface DepartmentRepository {
    Department save(Department department);

    Optional<Department> findById(Long id);

    List<Department> findAll();

    List<Department> findAllByName(String name);
}
