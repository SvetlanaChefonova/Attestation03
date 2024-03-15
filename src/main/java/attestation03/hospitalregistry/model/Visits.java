package attestation03.hospitalregistry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateValue;
import net.sf.jsqlparser.expression.TimeValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "visits")

public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //date_time_of_the_visit
   // @DateTimeFormat( pattern = "dd.MM.yyyy HH:mm")
    //private Date dateTimeOfTheVisit;

    @Column(name = "data_time_of_the_visit")
    private String dataTimeOfTheVisit;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false)
    private Patients patients;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctors doctors;

    @ManyToOne
    @JoinColumn(name="hospital_id", nullable = false)
    private Hospitals hospitals;


    //@OneToMany(cascade = CascadeType.ALL)   id_patient
   // private ;

   // @OneToMany(cascade = CascadeType.ALL) id_doctor
   // private ;

    //@OneToMany(cascade = CascadeType.ALL) id_hospital
    // private ;

}
