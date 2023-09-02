package dat3.car.api;


import dat3.car.dto.CarResponse;
import dat3.car.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path ="/{brand}/{model}")
    CarResponse getCarByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        return carService.findByBrandAndModel();
    }

}
