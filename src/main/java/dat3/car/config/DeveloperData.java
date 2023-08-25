package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

    CarRepository carRepository;
    MemberRepository memberRepository;

    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Car> cars = new ArrayList<>();
        List <Member> members = new ArrayList<>();
        System.out.println("I was called");

        cars.add(new Car("Ford", "Focus", 600, 25));
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

        members.add(new Member("user1", "pass1", "email1@example.com",
                "John", "Doe", "123 Main St", "Cityville", "12345"));
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

    }
}
