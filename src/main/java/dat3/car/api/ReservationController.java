package dat3.car.api;

import dat3.car.dto.ReservationRequest;
import dat3.car.dto.ReservationResponse;
import dat3.car.entity.Reservation;
import dat3.car.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    ReservationResponse makeReservation(@RequestBody ReservationRequest res) {
        // TODO tjek op
        return reservationService.reserveCar(res);
    }

    @GetMapping
    List<ReservationResponse> getReservations() {
        return reservationService.getReservations();
    }

}
