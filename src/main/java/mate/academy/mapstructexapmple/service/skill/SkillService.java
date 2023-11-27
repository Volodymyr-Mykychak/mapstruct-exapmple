package mate.academy.mapstructexapmple.service.skill;

import java.util.List;
import mate.academy.mapstructexapmple.dto.skill.CreateSkillRequestDto;
import mate.academy.mapstructexapmple.dto.skill.SkillDto;

public interface SkillService {
    SkillDto save(CreateSkillRequestDto requestDto);

    List<SkillDto> findAll();
}
