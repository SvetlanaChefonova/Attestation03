package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.HospitalsDto;
import attestation03.hospitalregistry.model.Hospitals;


import java.util.List;

public interface HospitalsServices {
    List<Hospitals> getAll();
    HospitalsDto getHospitalById(Long hospitalId);
    void deleteHospital(Long id);
    void deleteById(Long id);
}
