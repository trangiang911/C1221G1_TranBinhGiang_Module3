package repository;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository extends ICrudRepository<Employee> {
    @Override
    List<Employee> findAll();

    @Override
    void save(Employee employee);

    @Override
    Employee findById(Integer id);

    boolean update(Employee employee);

    boolean remove(Integer id);

    List<Employee> search(String name, String diaChi, String boPhan);
}
