package me.shockyng.api.services;

import jakarta.ejb.Stateless;
import me.shockyng.api.daos.CarsDAO;
import me.shockyng.api.data.dtos.CarDTO;
import me.shockyng.api.mappers.CarMapper;
import me.shockyng.api.data.models.Car;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CarsService {

    private final CarsDAO dao = new CarsDAO();

    public List<CarDTO> getAllCars() {
        return dao.findAll()
                .stream()
                .map(CarMapper.INSTANCE::carToCarDTO)
                .collect(Collectors.toList());
    }

    public CarDTO getOneCar(Long id) {
        return CarMapper.INSTANCE.carToCarDTO(dao.findOneById(id));
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.carDTOToCar(carDTO);
        Car savedCar = dao.save(car);
        return CarMapper.INSTANCE.carToCarDTO(savedCar);
    }

    public CarDTO updateCar(Long id, CarDTO carDTO) {
        Car foundCar = dao.findOneById(id);
        foundCar.setName(carDTO.name());
        foundCar.setYear(carDTO.year());
        Car updatedCar = dao.save(foundCar);
        return CarMapper.INSTANCE.carToCarDTO(updatedCar);
    }

    public void deleteCar(Long id) {
        dao.delete(id);
    }

}
