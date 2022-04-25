package service.impl;

import model.customer.Customer;
import model.customer.TypeCustomer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = iCustomerRepository.findAll();
        return customerList;
    }

    @Override
    public List<TypeCustomer> subFindAll() {
        List<TypeCustomer> typeCustomerList = iCustomerRepository.subFindAll();
        return typeCustomerList;
    }

    @Override
    public Map<String, String> save(Customer customer) {
        Map<String, String> map = new HashMap<>();
        if (customer.getHoTen().equals("")) {
            map.put("name", "Tên ko đc để trống");
        } else if (!customer.getHoTen().toLowerCase().matches("^([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){1,})$")) {
            map.put("name", "Tên ko hợp lệ");
        }
        if(customer.getSoCMND().equals("")){
            map.put("cmnd","Số cmnd ko đc để trống");
        }else if(!customer.getSoCMND().matches("^[0-9]{9,10}$")){
            map.put("cmnd","Số cmnd phải là số (có 9 hoạc 10 số)");
        }if(customer.getSoDienThoai().equals("")){
            map.put("sdt","sdt ko đc để trống");
        }else if(!customer.getSoDienThoai().matches("^[(090)|(091)|((84)+90)|((84)+91)]+([0-9]{6})$")){
            map.put("sdt","sđt phải đúng quy định ");
        }if(customer.getEmail().equals("")){
            map.put("email","Email ko đc để trống");
        }else if(!customer.getEmail().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            map.put("mail","email ko đúng quy định");
        }if (customer.getDiaChi().equals("")){
            map.put("dia_chi","địa chỉ k đc để trống");
        }
        if (map.isEmpty()) {
            iCustomerRepository.save(customer);
        }
        return map;
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public boolean update(Customer customer) {
        return iCustomerRepository.update(customer);
    }

    @Override
    public boolean remove(Integer id) {
        return iCustomerRepository.remove(id);
    }

    @Override
    public List<Customer> search(String name, String diaChi, String type) {
        return iCustomerRepository.search(name, diaChi, type);
    }


}
