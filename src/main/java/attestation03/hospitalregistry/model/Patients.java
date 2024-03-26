package attestation03.hospitalregistry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "patients")

public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    //date_of_birthday
    @Column(name = "date_Of_Birthday")
    private String dateOfBirthday;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "place_of_work")
    private String placeOfWork;

    @Column(name = "home_address")
    private String homeAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "policy_number")
    private Long policyNumber;

    @Column(name = "insurance_company")
    private String insuranceCompany;

    @Column(name = "has_deleted")
    private Boolean hasDeleted;

   // @OneToMany(mappedBy="patients")
  //  List<Visits>visits;
}
