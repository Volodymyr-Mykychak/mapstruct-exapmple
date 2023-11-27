package mate.academy.mapstructexapmple.repository.skill;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.mapstructexapmple.model.Skill;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SkillRepositoryImpl implements SkillRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Skill save(Skill skill) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(skill);
            transaction.commit();
            return skill;
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Skill> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("SELECT e FROM Skill  e",
                    Skill.class).getResultList();
        }
    }
}
