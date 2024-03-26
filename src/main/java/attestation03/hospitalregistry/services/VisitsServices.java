package attestation03.hospitalregistry.services;


import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.dto.VisitsDto;
import attestation03.hospitalregistry.model.Visits;

import java.util.List;

public interface VisitsServices {
   List<VisitsDto> getAll() ;

    void deleteById(Long visitId);
}
