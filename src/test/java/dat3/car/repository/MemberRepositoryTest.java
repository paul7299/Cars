package dat3.car.repository;

import dat3.car.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    boolean isInitialized = false;

    @BeforeEach
    void setUp() {

        if(!isInitialized) {
            memberRepository.deleteAll();
            memberRepository.save(new Member("user1", "pass1", "email1@example.com",
                    "John", "Doe", "123 Main St", "Cityville", "12345"));
            memberRepository.save(new Member("user2", "pass2", "email2@example.com",
                    "Jane", "Smith", "456 Elm St", "Townsville", "67890"));
            memberRepository.save(new Member("user3", "pass3", "email3@example.com",
                    "Michael", "Johnson", "789 Oak St", "Villagetown", "23456"));
            memberRepository.save(new Member("user4", "pass4", "email4@example.com",
                    "Emily", "Williams", "101 Maple St", "Countyville", "78901"));
            memberRepository.save(new Member("user5", "pass5", "email5@example.com",
                    "David", "Brown", "222 Pine St", "Metropolis", "34567"));
            isInitialized = true;
        }


    }

    @Test
    void findMemberByFirstName() {
        Member m = memberRepository.findMemberByFirstName("Jane");
        assertEquals("user2", m.getUsername());
    }

}