package service.impl;

import model.service_model.TypeService;
import repository.IServiceRepository;
import repository.ITypeRepository;
import repository.impl.ServiceRepository;
import repository.impl.TypeRepository;
import service.ITypeService;

import java.util.List;

public class TypeServiceImpl implements ITypeService {
    ITypeRepository iTypeRepository=new TypeRepository();
    @Override
    public List<TypeService> subFindType() {
        List<TypeService> typeServiceList= iTypeRepository.subFindType();
    return typeServiceList;
    }
}
