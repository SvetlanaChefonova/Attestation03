package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.model.Patients;

import java.util.List;


public interface PatientsServices {

    Patients findById(Long id);
    List<Patients> getAll();
    Patients savePatients(Patients patients);
    void deleteById(Long id);


    // public void update();

    //void savePatient(Patients patients);
}
