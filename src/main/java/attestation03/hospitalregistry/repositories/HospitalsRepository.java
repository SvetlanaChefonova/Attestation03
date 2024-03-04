package attestation03.hospitalregistry.repositories;

import attestation03.hospitalregistry.model.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalsRepository extends JpaRepository<Hospitals, Long> {

        //void validateHospital(Hospitals hospital) throws InvalidHospitalException;
        //void createPatient(Hospitals hospital) throws InavalidHospitalException;
        //Hospitals void findByID(String id) throws IOExcepton;
        //void update(Hospitals hospital);
        //void deleteById(Long id);
}

