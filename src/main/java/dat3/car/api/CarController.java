package dat3.car.api;


import dat3.car.dto.CarRequest;
import dat3.car.dto.CarResponse;
import dat3.car.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Controlleren kender til JSON og konvertere til objekt
@RequestMapping("api/cars")
public class CarController {

    // Controller bruger en Service for forretningslogikken
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /* ------- CRUD API BELOW -------  */

    /* READ */

    // Hent alle biler, som CarResponse's, da de jo skal sendes til front-end
    // Security: Anonymous
    @GetMapping
    List<CarResponse> getCars() {
        return carService.getCars(false);
    }

    // Security: Admin
    @GetMapping(path ="/{id}")
    CarResponse getCarById(@PathVariable int id) {
        return carService.findById(id);
    }

    // Security: Anonymous
    @GetMapping(path ="/{brand}/{model}")
    CarResponse getCarByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        return carService.findByBrandAndModel(brand, model);
    }

    /* UPDATE */
    // Security: Admin
    @PutMapping("/{id}")
    ResponseEntity<Boolean> editCar(@RequestBody CarRequest body, @PathVariable int id){
        return carService.editCar(body, id);
    }

    // Security: Admiin
    // Opdater pris for en bil baseret på brand/model (mulig det burde være id, men opgaven siger ikke noget om dette)
    @PatchMapping("/{brand}/{model}/pricePrDay/value")
    void setPricePrDayForCar(@PathVariable String brand, @PathVariable String model, @PathVariable int value) {
        carService.setPricePrDayForCar(brand, model, value);
    }

    /* CREATE */
    // TODO hvorfor skal denne returnere noget
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body) {
        return carService.addCar(body);
    }

    /* DELETE */
    // Security: Admin
    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable int id) {
        carService.deleteCarById(id);
    }


}
