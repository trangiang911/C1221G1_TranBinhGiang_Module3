package service.impl;

import model.employee.Division;
import model.employee.Education;
import repository.IEducationRepository;
import repository.impl.EducationRepository;
import service.IEducationService;

import java.util.List;

public class EducationService implements IEducationService {
    IEducationRepository iEducationRepository=new EducationRepository();
    @Override
    public List<Education> findEducation() {
        List<Education> educationList=iEducationRepository.subFindDivision();
        return educationList;    }
}
