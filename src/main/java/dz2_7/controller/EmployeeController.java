package dz2_7.controller;


import dz2_7.service.Employee;
import dz2_7.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")      // добавить сотрудника
    public Employee addEmployee(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("patronymic") String patronymic) {
        return employeeService.addEmployee(lastName, firstName, patronymic);
    }
    @GetMapping("/delete")    // удалить сотрудника
    public Employee deleteEmployee(@RequestParam("lastName") String lastName,
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("patronymic") String patronymic) {
        return employeeService.deleteEmployee(lastName, firstName, patronymic);
    }
    @GetMapping("/find")      // проверить на наличие сотрудника
    public Employee findEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("patronymic") String patronymic) {
        return employeeService.findEmployee(lastName, firstName, patronymic);
    }
    @GetMapping      // список сотрудников
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

}
