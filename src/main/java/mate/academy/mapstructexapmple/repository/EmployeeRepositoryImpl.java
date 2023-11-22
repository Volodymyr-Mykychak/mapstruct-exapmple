package mate.academy.mapstructexapmple.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mate.academy.mapstructexapmple.model.Employee;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Employee save(Employee employee) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            return employee;
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Employee employee = entityManager.find(Employee.class, id);
            return Optional.ofNullable(employee);
        }
    }

    @Override
    public List<Employee> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("SELECT e FROM Employee  e",
                    Employee.class).getResultList();
        }
    }

    @Override
    public List<Employee> findAllByName(String name) {
        String lowerCaseName = name.toLowerCase();
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager
                    .createQuery("SELECT e FROM Employee e WHERE lower(e.name) "
                            + "LIKE :name", Employee.class)
                    .setParameter("name", "%" + lowerCaseName + "%")
                    .getResultList();
        }
    }
}
