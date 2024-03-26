package attestation03.hospitalregistry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="patient_test")
public class PatientTest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="last_name")
    private String lastName;
    @Column(name="name")
    private String name;
    @Column(name="patronymic")
    private String patronymic;



}
