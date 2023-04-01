package me.shockyng.api.mappers;

import me.shockyng.api.dtos.EngineDTO;
import me.shockyng.api.models.Engine;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EngineMapper {

    EngineMapper INSTANCE = Mappers.getMapper( EngineMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Engine engineDTOToEngine(EngineDTO engineDTO);

    @InheritInverseConfiguration
    EngineDTO engineToEngineDTO(Engine engine);
}
