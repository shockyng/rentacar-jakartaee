package me.shockyng.api.mappers;

import me.shockyng.api.dtos.CarDTO;
import me.shockyng.api.models.Car;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "year", target = "year")
    Car carDTOToCar(CarDTO car);

    @InheritInverseConfiguration
    CarDTO carToCarDTO(Car car);
}
