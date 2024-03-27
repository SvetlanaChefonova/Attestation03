package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.dto.PatientsPage;
import attestation03.hospitalregistry.exception.PatientNotFoundException;
import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.repositories.PatientsRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientsServicesImpl implements PatientsServices{

    private final PatientsRepository patientsRepository;

   // @Value("${page-size}")
  //  private int PageSize;

    /**
     * Получить всех поциентов из БД
     *
     * @return список пациентов
     */
    @Override
    public List<Patients> getAll() {
       return patientsRepository.findAllButNotHasDeleted(); //аналог SELEST * from patients;
    }

   /* @Override
    public PatientsPage getAllPatientsByPage(int page) {
        PageRequest pageRequest = PageRequest.of(page, PageSize);
        Page<Patients> patientsByPage = patientsRepository.findAll(pageRequest);

        return PatientsPage.builder()
                .patients(Collections.singletonList(from((Patients) patientsByPage.getContent())))
                .totalPagesCount(patientsByPage.getTotalPages())
                .build();
    }*/


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

    @Override
    public void deletePatient(Long id) {

    }


}
