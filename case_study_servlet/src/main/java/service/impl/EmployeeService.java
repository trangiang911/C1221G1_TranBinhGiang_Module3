package service.impl;

import model.employee.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository iEmployeeRepository=new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList=iEmployeeRepository.findAll();
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public boolean update(Employee employee) {
        return iEmployeeRepository.update(employee);
    }

    @Override
    public boolean remove(Integer id) {
        return iEmployeeRepository.remove(id);
    }

    @Override
    public List<Employee> search(String name, String diaChi, String boPhan) {
        return iEmployeeRepository.search(name,diaChi,boPhan);
    }

}
