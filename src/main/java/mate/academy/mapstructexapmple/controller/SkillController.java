package mate.academy.mapstructexapmple.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.mapstructexapmple.dto.skill.CreateSkillRequestDto;
import mate.academy.mapstructexapmple.dto.skill.SkillDto;
import mate.academy.mapstructexapmple.service.skill.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/skills")
public class SkillController {
    private final SkillService skillService;

    @GetMapping
    public List<SkillDto> findAll() {
        return skillService.findAll();
    }

    @PostMapping
    public SkillDto save(@RequestBody CreateSkillRequestDto requestDto) {
        return skillService.save(requestDto);
    }
}
