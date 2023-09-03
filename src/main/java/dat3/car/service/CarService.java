package dat3.car.service;

import dat3.car.dto.CarRequest;
import dat3.car.dto.CarResponse;
import dat3.car.dto.MemberResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
Service-klassen bruges til business logic mlm. Repository og Controller.
 */

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Henter alle Cars fra repository og returnerer dem som CarResponse's
    public List<CarResponse> getCars(boolean includeAll) {

        List<Car> cars = carRepository.findAll();

        List<CarResponse> response = cars.stream().map(car -> new CarResponse(car, includeAll)).toList();

        /* Det der sker over er det samme som:

        List <CarResponse> response = new ArrayList<>();
        for (Car c : cars) {
            CarResponse cr = new CarResponse(c, includeAll);
            response.add(cr);
        } */
        return response;
    }

    // Finder bil efter ID og returnerer en carResponse (på admin niveau)
    public CarResponse findById(int id) {
        //TODO ved ikke hvad der sker her
        Car car = carRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car with this username does not exist"));

        return new CarResponse(car, true);
    }

    // Finder bil efter brand og model og returnerer som carResponse på anonymous security niveau
    public CarResponse findByBrandAndModel(String brand, String model) {

        Car car = carRepository.findCarByBrandAndModel(brand, model);

        return new CarResponse(car, false);
    }

    public ResponseEntity<Boolean> editCar(CarRequest body, int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car with this username does not exist"));
        if(body.getId() != id){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change username (car)");
            // han mener nok member/car her, ikke username
        }

        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setPricePrDay(body.getPricePrDay());
        car.setBestDiscount(body.getBestDiscount());
        carRepository.save(car);

        return ResponseEntity.ok(true);
    }

    public CarResponse addCar(CarRequest body) {

        // Konverterer CarRequest til Car vha. metode i CarRequest og body-parameteret
        Car newCar = CarRequest.getCarEntity(body);

        carRepository.save(newCar);

        return new CarResponse(newCar, true);
    }

    public void setPricePrDayForCar(String brand, String model, int value) {

        // Bruger repo metode til at hente rigtig Car
        Car car = carRepository.findCarByBrandAndModel(brand, model);
        // Sætter værdi
        car.setPricePrDay(value);
        // Saver - overskriver original da det er samme PK
        carRepository.save(car);

    }

    public void deleteCarById(int id) {
        Car car = getCarById(id);
        carRepository.delete(car);
    }

    // TODO Hvorfor bruge denne istedet for at kalde direkte fra repo? Gælder det kun hvis det er primary key?
    private Car getCarById(int id){
        return carRepository.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car with this ID does not exist"));
    }

}
