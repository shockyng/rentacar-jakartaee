package me.shockyng.rentacarjakartaee.daos;

import jakarta.ejb.Stateless;
import me.shockyng.rentacarjakartaee.data.models.Car;

@Stateless
public class CarsDAO extends BaseDAO<Car, Long> {

    public CarsDAO() {
        super(Car.class);
    }

}
