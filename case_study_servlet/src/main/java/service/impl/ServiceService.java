package service.impl;

import model.customer.Customer;
import model.service_model.Service;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import service.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
IServiceRepository iServiceRepository=new ServiceRepository();
    @Override
    public List<Service> findAll() {
        List<Service> serviceList=iServiceRepository.findAll();
        return serviceList;
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }
}
