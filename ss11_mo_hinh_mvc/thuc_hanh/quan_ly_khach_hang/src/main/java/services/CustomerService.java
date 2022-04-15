package services;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
public static List<Customer> customerList=new ArrayList<>();

static {
    customerList.add(new Customer(1,"Trần Bình Giảng","tbg@gmail.com","Huế"));
    customerList.add(new Customer(2,"Nghĩa Trình","tbg@gmail.com","Huế"));
    customerList.add(new Customer(3,"Ngô Hoàng Long","tbg@gmail.com","Huế"));
    customerList.add(new Customer(4,"Bùi Quốc Tín","tbg@gmail.com","Huế"));
}
    @Override
    public List<Customer> display() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
            customerList.add(customer);
    }

    @Override
    public void edit(Integer id) {

    }

    @Override
    public void del(Integer id) {
        customerList.remove(id);
    }

    @Override
    public Customer find(Integer id) {
        return customerList.get(id);
    }
}
