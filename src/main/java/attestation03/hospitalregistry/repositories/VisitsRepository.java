package attestation03.hospitalregistry.repositories;


import attestation03.hospitalregistry.model.Visits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitsRepository extends JpaRepository<Visits, Long> {


}