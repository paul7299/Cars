package dat3.car.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "member")
public class Member extends AdminDetails {

    @Id
    String username;
    String password;
    String email;
    String firstName;
    String lastName;
    String street;
    String city;
    String  zip;
    boolean approved;
    int ranking;

    public Member(String user, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        this.username = user;
        this.password= password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

}
