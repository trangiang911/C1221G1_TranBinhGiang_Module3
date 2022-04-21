package service.impl;

import model.employee.Division;
import model.service_model.RentType;
import repository.IDivisionRepository;
import repository.impl.DivisionRepository;
import service.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    IDivisionRepository iDivisionRepository= new DivisionRepository();
    @Override
    public List<Division> findDivision() {
        List<Division> divisionList=iDivisionRepository.subFindDivision();
        return divisionList;
    }
}
