package dat3.car.service;

import dat3.car.dto.CarResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
Service-klassen bruges til business logic mlm. Repository og Controller.
og skal derfor indeholde: // TODO
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
        List <CarResponse> response = new ArrayList<>();

        for (Car c : cars) {
            CarResponse cr = new CarResponse(c, includeAll);
            response.add(cr);
        }

        // Anden måde (fra Member)
        // List<MemberResponse> response = members.stream().map(member -> new MemberResponse(member, includeAll)).toList();

        return response;
    }

    public CarResponse findById(int id) {


        Car car = carRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car with this username does not exist"));
                //TODO ved ikke hvad der sker her
        return new CarResponse(car, true);

    }

    public CarResponse findByBrandAndModel() {

        return null;
    }
}
