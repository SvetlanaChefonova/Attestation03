package attestation03.hospitalregistry.repositories;


import attestation03.hospitalregistry.model.Patients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

    @Query(value = "select p from Patients p where p.hasDeleted = false")
    List<Patients> findAllButNotHasDeleted();
    Page<Patients> findAll(Pageable pageable);


}


