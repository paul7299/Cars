package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {

    CarRepository carRepository;
    MemberRepository memberRepository;
    ReservationRepository reservationRepository;

    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Car> cars = new ArrayList<>();
        List <Member> members = new ArrayList<>();
        System.out.println("I was called");

        Car car1 = new Car("Ford", "Focus", 600, 25);

        cars.add(car1);
        cars.add(new Car("Chevrolet", "Cruze", 550, 10));
        cars.add(new Car("Nissan", "Sentra", 700, 30));
        cars.add(new Car("Volkswagen", "Golf", 800, 18));
        cars.add(new Car("Hyundai", "Elantra", 900, 22));
        cars.add(new Car("Kia", "Optima", 400, 8));
        cars.add(new Car("Mazda", "Mazda3", 550, 12));
        cars.add(new Car("Subaru", "Impreza", 300, 10));
        cars.add(new Car("BMW", "3 Series", 1000, 28));
        cars.add(new Car("Mercedes-Benz", "C-Class", 1100, 25));
        cars.add(new Car("Audi", "A4", 950, 15));
        cars.add(new Car("Lexus", "ES", 1200, 20));
        cars.add(new Car("Infiniti", "Q50", 800, 18));
        cars.add(new Car("Acura", "TLX", 850, 12));
        cars.add(new Car("Tesla", "Model 3", 1300, 30));
        cars.add(new Car("Porsche", "Panamera", 2000, 28));
        cars.add(new Car("Jaguar", "XE", 1800, 25));
        cars.add(new Car("Land Rover", "Discovery", 2500, 15));
        cars.add(new Car("Volvo", "S60", 1100, 10));
        cars.add(new Car("Mini", "Cooper", 600, 8));
        cars.add(new Car("Ferrari", "458 Italia", 3000, 5));

        carRepository.saveAll(cars);

        Member m1 = new Member("user1", "pass1", "email1@example.com",
                "John", "Doe", "123 Main St", "Cityville", "12345");

        members.add(m1);
        members.add(new Member("user2", "pass2", "email2@example.com",
                "Jane", "Smith", "456 Elm St", "Townsville", "67890"));
        members.add(new Member("user3", "pass3", "email3@example.com",
                "Michael", "Johnson", "789 Oak St", "Villagetown", "23456"));
        members.add(new Member("user4", "pass4", "email4@example.com",
                "Emily", "Williams", "101 Maple St", "Countyville", "78901"));
        members.add(new Member("user5", "pass5", "email5@example.com",
                "David", "Brown", "222 Pine St", "Metropolis", "34567"));
        members.add(new Member("user6", "pass6", "email6@example.com",
                "Sophia", "Jones", "333 Cedar St", "Urbanville", "45678"));
        members.add(new Member("user7", "pass7", "email7@example.com",
                "Liam", "Miller", "444 Birch St", "Suburbia", "56789"));
        members.add(new Member("user8", "pass8", "email8@example.com",
                "Olivia", "Davis", "555 Walnut St", "Township", "67890"));
        members.add(new Member("user9", "pass9", "email9@example.com",
                "Ethan", "Moore", "666 Oak St", "Hamlet", "78901"));
        members.add(new Member("user10", "pass10", "email10@example.com",
                "Ava", "Wilson", "777 Maple St", "Ruralville", "89012"));

        memberRepository.saveAll(members);

        LocalDate date1 = LocalDate.now().plusDays(2);
        LocalDate date2 = LocalDate.of(2023,12,12);
        Reservation r1 = new Reservation(m1, car1, date1);
        Reservation r2 = new Reservation(m1, car1, date2);


        reservationRepository.save(r1);
        reservationRepository.save(r2);

        System.out.println("CHECK =>>>>  " + car1.getReservations().size());
        System.out.println("CHECK =>>>> " + m1.getReservations().size());

        System.out.println("Should find: " + reservationRepository.existsByCarIdAndRentalDate(car1.getId(), date2));

        setupUserWithRoleUsers();

    }

    @Autowired
    UserWithRolesRepository userWithRolesRepository;

    final String passwordUsedByAll = "test123";

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {

        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user11", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user12", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user13", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user14", passwordUsedByAll, "user4@a.dk");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        //No Role assigned to user4


        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);


    }



}
