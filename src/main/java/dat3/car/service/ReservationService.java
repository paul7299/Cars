package dat3.car.service;

import dat3.car.dto.MemberResponse;
import dat3.car.dto.ReservationRequest;
import dat3.car.dto.ReservationResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    CarRepository carRepository;
    MemberRepository memberRepository;


    public ReservationService(ReservationRepository reservationRepository, CarRepository carRepository, MemberRepository memberRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }

    public List<ReservationResponse> getReservations() {
        // Henter alle reservations fra repo
        List<Reservation> reservations = reservationRepository.findAll();

        // Streamer alle reservations inn i en reservationsRepsons liste (kunne også brukt foreach)
        List<ReservationResponse> response = reservations.stream().map(reservation -> new ReservationResponse(reservation)).toList();

        return response;
    }

    public ReservationResponse reserveCar(ReservationRequest body) {
        if(LocalDate.now().isAfter(body.getRentalDate())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"*** Date in the past not allowed ***");
        }

        // TODO Side note: Hvorfor giver findById Optional?
        //Reservation reservation = new Reservation(memberRepository.findById(body.getUsername()), body.getCarId(), body.getRentalDate());

        Member member = memberRepository.findById(body.getUsername()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No member with this name"));
        Car car = carRepository.findById(body.getCarId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No car with this ID"));

        // Tjekker om bilen er reserveret denne dato
        if(reservationRepository.existsByCarIdAndRentalDate(body.getCarId(), body.getRentalDate())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"*** This car is reserved on this date ***");
        }

        Reservation res = new Reservation(member, car, body.getRentalDate());

        reservationRepository.save(res);

        return new ReservationResponse(res);

    }

}
