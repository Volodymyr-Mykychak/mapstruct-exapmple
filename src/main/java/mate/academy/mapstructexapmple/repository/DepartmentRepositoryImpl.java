package mate.academy.mapstructexapmple.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mate.academy.mapstructexapmple.model.Department;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Department save(Department department) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(department);
            transaction.commit();
            return department;
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Optional<Department> findById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Department department = entityManager.find(Department.class, id);
            return Optional.ofNullable(department);
        }
    }

    @Override
    public List<Department> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("SELECT e FROM Department e",
                    Department.class).getResultList();
        }
    }

    @Override
    public List<Department> findAllByName(String name) {
        String lowerCaseName = name.toLowerCase();
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager
                    .createQuery("SELECT e FROM Department  e WHERE lower(e.name) "
                            + "LIKE :name", Department.class)
                    .setParameter("name", "%" + lowerCaseName + "%")
                    .getResultList();
        }
    }
}
