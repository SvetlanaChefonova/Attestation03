package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.DoctorsDto;
import attestation03.hospitalregistry.dto.HospitalsDto;
import attestation03.hospitalregistry.model.Doctors;


import java.util.List;

public interface DoctorsServices {
    List<Doctors>getAll();
    DoctorsDto getDoctorById(Long doctorId);
    void deleteDoctor(Long id);
    void deleteById(Long id);
}
