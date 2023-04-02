package me.shockyng.api.dtos;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public record CarDTO(
        Long id,
        @Size(min = 2, max = 14)
        String name,
        Integer year,
        EngineDTO engine
) { }

