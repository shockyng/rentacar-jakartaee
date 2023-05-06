package me.shockyng.api.daos;

import me.shockyng.api.data.models.Car;

public class CarsDAO extends BaseDAO<Car, Long> {

    public CarsDAO() {
        super(Car.class);
    }

}
