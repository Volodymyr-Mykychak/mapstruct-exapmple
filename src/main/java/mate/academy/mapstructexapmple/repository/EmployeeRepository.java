package mate.academy.mapstructexapmple.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.mapstructexapmple.model.Employee;

public interface EmployeeRepository {
    Employee save(Employee employee);

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    List<Employee> findAllByName(String name);
}
