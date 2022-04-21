package service;

import model.service_model.Service;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();

    void save(Service service);
}
