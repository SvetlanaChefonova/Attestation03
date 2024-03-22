package attestation03.hospitalregistry.repositories;


import attestation03.hospitalregistry.model.Patients;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

    @Query(value = "select p from Patients p where p.hasDeleted = true")
    List<Patients> findAllButNotHasDeleted();


    //void validatePatient(Patients patient) throws InvalidPatientException;
    //void createPatient(Patients patient) throws InavalidPatientException;
    //Patients void findByID(String id) throws IOExcepton;
    //void update(Patients patient);
    //void deleteById(Long id);
}


