package me.shockyng.api.dtos;

public record CarDTO(
        Long id,
        String name,
        Integer year,
        EngineDTO engine
) { }

