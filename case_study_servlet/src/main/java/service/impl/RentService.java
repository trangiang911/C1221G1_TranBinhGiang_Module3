package service.impl;

import model.customer.TypeCustomer;
import model.service_model.RentType;
import repository.IRentRepository;
import repository.impl.RentRepository;
import service.IRentService;

import java.util.List;

public class RentService implements IRentService {
    IRentRepository iRentRepository=new RentRepository();

    @Override
    public List<RentType> subFindRent() {
        List<RentType> rentRepositoryList=iRentRepository.subFindRent();
        return rentRepositoryList;
    }
}
