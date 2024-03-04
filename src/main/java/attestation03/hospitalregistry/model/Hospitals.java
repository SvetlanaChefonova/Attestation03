package attestation03.hospitalregistry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hospitals")
public class Hospitals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "hospital_address")
    private String hospitalAddress;

    @Column(name = "hospital_phone")
    private Integer hospitalPhone;

    @OneToMany(mappedBy="hospitals")
    List<Visits> visits;

}
