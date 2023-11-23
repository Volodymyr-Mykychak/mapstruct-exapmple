package mate.academy.mapstructexapmple.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.mapstructexapmple.dto.CreateDepartmentRequestDto;
import mate.academy.mapstructexapmple.dto.DepartmentDto;
import mate.academy.mapstructexapmple.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentDto findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @GetMapping("/by-name")
    public List<DepartmentDto> getAllByName(@RequestParam String name) {
        return departmentService.getAllByName(name);
    }

    @PostMapping
    public DepartmentDto save(@RequestBody CreateDepartmentRequestDto requestDto) {
        return departmentService.save(requestDto);
    }
}
