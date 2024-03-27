package attestation03.hospitalregistry.repositories;

import attestation03.hospitalregistry.model.Doctors;
import attestation03.hospitalregistry.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {


}


