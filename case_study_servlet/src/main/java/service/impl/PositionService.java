package service.impl;

import model.employee.Position;
import model.service_model.RentType;
import repository.IPosititonRepossitory;
import repository.impl.PositionRepository;
import service.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    IPosititonRepossitory iPosititonRepossitory=new PositionRepository();
    @Override
    public List<Position> findPosition() {
        List<Position> positionList=iPosititonRepossitory.subFindPosition();
        return positionList;}
}
