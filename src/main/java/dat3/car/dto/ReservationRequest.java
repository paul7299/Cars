package dat3.car.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

// Kan laves uden denne DTO i Postman: POST api/reservations/{carid}/{username}/{date}

public class ReservationRequest {

    int carId;
    String username;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    LocalDate rentalDate;

}
