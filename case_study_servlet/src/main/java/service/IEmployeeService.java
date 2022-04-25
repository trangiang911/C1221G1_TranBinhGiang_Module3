package service;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    boolean update(Employee employee);

    boolean remove(Integer id);

    List<Employee> search(String name, String diaChi, String boPhan);
}
