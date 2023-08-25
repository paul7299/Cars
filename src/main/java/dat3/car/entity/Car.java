package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "car_brand", nullable = false, length = 50)
    String brand;
    @Column(name = "car_model", nullable = false, length = 60)
    String model;
    @Column(name = "rental_price_day")
    double pricePrDay;
    @Column(name = "max_discount")
    int bestDiscount;
    @CreationTimestamp
    LocalDateTime created;
    @UpdateTimestamp
    LocalDateTime lastEdited;

    public Car(String brand, String model, double pricePrDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

}
