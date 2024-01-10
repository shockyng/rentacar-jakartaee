package me.shockyng.rentacarjakartaee.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import me.shockyng.rentacarjakartaee.daos.CarsDAO;
import me.shockyng.rentacarjakartaee.data.dtos.CarDTO;
import me.shockyng.rentacarjakartaee.data.models.Car;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class CarsService {

    @Inject
    private CarsDAO dao;

    public List<CarDTO> getAllCars() {
        List<Car> allCars = dao.findAll();
        List<CarDTO> allCarsDTO = new ArrayList<>();

        for (Car car : allCars) {
            CarDTO carDTO = convertCarEntityInCarDTO(car);
            allCarsDTO.add(carDTO);
        }

        return allCarsDTO;
    }

    public CarDTO getOneCar(Long id) {
        Car foundCar = dao.findOneById(id);
        return new CarDTO(foundCar.getId(), foundCar.getName(), foundCar.getYear());
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car carToSave = new Car();
        carToSave.setName(carDTO.name());
        carToSave.setYear(carDTO.year());
        Car savedCar = dao.save(carToSave);
        return convertCarEntityInCarDTO(savedCar);
    }

    public CarDTO updateCar(Long id, CarDTO carDTO) {
        Car foundCar = dao.findOneById(id);
        foundCar.setName(carDTO.name());
        foundCar.setYear(carDTO.year());
        Car updatedCar = dao.save(foundCar);
        return convertCarEntityInCarDTO(updatedCar);
    }

    public void deleteCar(Long id) {
        dao.delete(id);
    }

    private CarDTO convertCarEntityInCarDTO(Car car) {
        return new CarDTO(car.getId(), car.getName(), car.getYear());
    }

    public List<CarDTO> searchForCars(String carName) {
        List<Car> allCars = dao.searchByName(carName);
        List<CarDTO> allCarsDTO = new ArrayList<>();

        for (Car car : allCars) {
            CarDTO carDTO = convertCarEntityInCarDTO(car);
            allCarsDTO.add(carDTO);
        }

        return allCarsDTO;
    }
}
