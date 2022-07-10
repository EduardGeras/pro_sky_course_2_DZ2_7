package dz2_7.service;


import org.springframework.stereotype.Service;
import dz2_7.exception.EmployeeAlreadyAddedException;
import dz2_7.exception.EmployeeNotFoundException;
import dz2_7.exception.EmployeeStoragelsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static final int limit = 10;
    public static Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee (String firstName, String lastName, String patronymic) {
        Employee employee = new Employee(firstName, lastName, patronymic);
        String key = getKey(firstName, lastName, patronymic);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        if (employees.size() < limit) {
            employees.put(key,employee);
            return employee;
        }
        throw new EmployeeStoragelsFullException("Штат сотрудников полный. Кого увольняем?)");
    }

    public Employee deleteEmployee (String firstName, String lastName, String patronymic) {
        String key = getKey(firstName, lastName, patronymic);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в организации");
        }
        return employees.remove(key);
    }

    public Employee findEmployee (String firstName, String lastName, String patronymic) {
        String key = getKey(firstName, lastName, patronymic);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в организации");
        }
        return employees.get(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
    private String getKey(String firstName, String lastName, String patronymic) {
        return firstName + " " + lastName + " " + patronymic;
    }

}
