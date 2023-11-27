package mate.academy.mapstructexapmple.repository.skill;

import java.util.List;
import mate.academy.mapstructexapmple.model.Skill;

public interface SkillRepository {
    Skill save(Skill skill);

    List<Skill> findAll();
}
