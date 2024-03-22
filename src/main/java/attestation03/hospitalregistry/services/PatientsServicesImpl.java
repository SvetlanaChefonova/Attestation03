package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.exception.PatientNotFoundException;
import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.repositories.PatientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import java.io.IOException;
import java.util.List;

import static java.util.Date.from;

@Service
@RequiredArgsConstructor
public class PatientsServicesImpl implements PatientsServices{

    private final PatientsRepository patientsRepository;

    /**
     * Получить всех поциентов из БД
     * @return список пациентов
     */
    @Override
    public List<Patients> getAll() {
        return patientsRepository.findAllButNotHasDeleted(); //аналог SELEST * from patients;
    }

    @Override
    public PatientsDto getPatientById(Long patientId) {
        Patients patients =patientsRepository.findById(patientId)
                .orElseThrow(PatientNotFoundException::new);
        if (patients.getHasDeleted()){
            throw new PatientNotFoundException();
        }
        return from(patients);
    }

    @Override
    public PatientsDto addPatient(PatientsDto patients) {
        return from(patientsRepository.save(
                Patients.builder()
                        .id(patients.getId())
                        .lastName(patients.getLastName())
                        .name(patients.getName())
                        .patronymic(patients.getPatronymic())
                        .build()));
    }

    public static PatientsDto from(Patients patients) {
        return PatientsDto.builder()
                .id(patients.getId())
                .lastName(patients.getLastName())
                .name(patients.getName())
                .patronymic(patients.getPatronymic())
                .build();
    }




    @Override
    public PatientsDto updatePatient(Long patientId, PatientsDto newData) {
        Patients patients = patientsRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);

        patients.setLastName(newData.getLastName());
        patients.setName(newData.getName());
        patients.setPatronymic(newData.getPatronymic());

        return from(patientsRepository.save(patients));
    }


    @Override
    public void deleteById(Long id){
        patientsRepository.deleteById(id);
    }

    @Override
    public void softDeleteById(Long patientId){
        Patients patients = patientsRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);

        patients.setHasDeleted(true);
        patientsRepository.save(patients);
    }


    // @Override
    // public Patients findById(Long id){
    // return patientsRepository.getOne(id);
    // }

    // @Override
    //public Patients savePatients(Patients patients){
    //return patientsRepository.save(patients);
    //}
}
