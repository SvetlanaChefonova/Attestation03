package attestation03.hospitalregistry.repositories;


import attestation03.hospitalregistry.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

    //void validatePatient(Patients patient) throws InvalidPatientException;
    //void createPatient(Patients patient) throws InavalidPatientException;
    //Patients void findByID(String id) throws IOExcepton;
    //void update(Patients patient);
    //void deleteById(Long id);
}


