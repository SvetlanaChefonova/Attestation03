package attestation03.hospitalregistry.repositories;


import attestation03.hospitalregistry.model.Visits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitsRepository extends JpaRepository<Visits, Long> {

    //void validateVisits(Visits visit) throws InvalidVisitException;
    //void createVisit(Visits visit) throws InavalidVisitException;
    //Visits void findByID(String id) throws IOExcepton;
    //void update(Visits visit);
    //void deleteById(Long id);
}