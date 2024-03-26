package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.dto.PatientsPage;
import attestation03.hospitalregistry.model.Patients;

import java.util.List;


public interface PatientsServices {
    List<Patients> getAll();
    PatientsPage getAllPatientsByPage(int page);
    PatientsDto getPatientById(Long patientId);
    PatientsDto addPatient(PatientsDto patients);
    PatientsDto updatePatient(Long patientId, PatientsDto newData);
    void deleteById(Long id);
    void softDeleteById(Long patientId);

    void deletePatient(Long id);
}
