package mate.academy.mapstructexapmple.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.mapstructexapmple.dto.employee.CreateEmployeeRequestDto;
import mate.academy.mapstructexapmple.dto.employee.EmployeeDto;
import mate.academy.mapstructexapmple.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable Long id) {
        // http://localhost:8080/epmloyees/id
        return employeeService.findById(id);
    }

    @GetMapping("/by-name")
    public List<EmployeeDto> getAllByName(@RequestParam String name) {
        // http://localhost:8080/epmloyees/by-name?name=Bob
        return employeeService.getAllByName(name);
    }

    @PostMapping
    public EmployeeDto save(@RequestBody CreateEmployeeRequestDto requestDto) {
        return employeeService.save(requestDto);
    }
}
