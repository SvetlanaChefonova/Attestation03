package attestation03.hospitalregistry.repositories;

import attestation03.hospitalregistry.model.Doctors;
import attestation03.hospitalregistry.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<Doctors, Long> {

    //void validateDoctor(Doctors doctor) throws InvalidDoctorException;
    //void createDoctor(Doctors doctor) throws InavalidDoctorException;
    //Doctors void findByID(String id) throws IOExcepton;
    //void update(Doctors doctor);
    //void deleteById(Long id);
}


