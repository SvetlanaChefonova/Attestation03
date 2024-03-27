package attestation03.hospitalregistry.repositories;


import attestation03.hospitalregistry.model.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VisitsRepository extends JpaRepository<Visits, Long> {


}