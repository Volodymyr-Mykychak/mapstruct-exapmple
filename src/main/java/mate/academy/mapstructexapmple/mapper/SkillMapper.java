package mate.academy.mapstructexapmple.mapper;

import mate.academy.mapstructexapmple.config.MapperConfig;
import mate.academy.mapstructexapmple.dto.skill.CreateSkillRequestDto;
import mate.academy.mapstructexapmple.dto.skill.SkillDto;
import mate.academy.mapstructexapmple.model.Skill;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SkillMapper {

    SkillDto toDto(Skill skill);

    Skill toModel(CreateSkillRequestDto requestDto);
}
