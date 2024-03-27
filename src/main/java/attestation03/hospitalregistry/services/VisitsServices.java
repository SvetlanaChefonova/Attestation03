package attestation03.hospitalregistry.services;


import attestation03.hospitalregistry.dto.HospitalsDto;
import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.dto.VisitsDto;
import attestation03.hospitalregistry.model.Visits;

import java.util.List;

public interface VisitsServices {
    List<VisitsDto> getAll() ;
    VisitsDto getVisitById(Long hospitalId);
    void deleteVisit(Long id);
    void deleteById(Long visitId);
}
