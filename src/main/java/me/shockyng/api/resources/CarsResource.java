package me.shockyng.api.resources;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.shockyng.api.data.dtos.CarDTO;
import me.shockyng.api.services.CarsService;

import java.util.List;

@Path("/v1/car")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class CarsResource {

    private final CarsService service = new CarsService();

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
    public CarDTO createCar(@Valid CarDTO carDTO) {
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

}