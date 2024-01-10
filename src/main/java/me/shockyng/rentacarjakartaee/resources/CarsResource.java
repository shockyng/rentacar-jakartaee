package me.shockyng.rentacarjakartaee.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.shockyng.rentacarjakartaee.data.dtos.CarDTO;
import me.shockyng.rentacarjakartaee.services.CarsService;

import java.util.List;

@Path("/v1/cars")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class CarsResource {

    @Inject
    private CarsService service;

    @GET
    public List<CarDTO> getCars() {
        return service.getAllCars();
    }

    @GET
    @Path("/{id}")
    public CarDTO getOneCar(@PathParam("id") Long id) {
        return service.getOneCar(id);
    }

    @POST
    public CarDTO createCar(CarDTO carDTO) {
        return service.createCar(carDTO);
    }

    @PUT
    @Path("/{id}")
    public CarDTO updateCar(@PathParam("id") Long id, CarDTO carDTO) {
        return service.updateCar(id, carDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCar(@PathParam("id") Long id) {
        service.deleteCar(id);
    }

    @GET
    @Path("/search")
    public List<CarDTO> searchCars(@QueryParam("name") String carName) {
        return service.searchForCars(carName);
    }

}