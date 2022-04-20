package repository;

import model.service_model.RentType;

import java.util.List;

public interface IRentRepository {
    List<RentType> subFindRent();
}
