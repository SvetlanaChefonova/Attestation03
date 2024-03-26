package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.HospitalsDto;
import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.exception.PatientNotFoundException;
import attestation03.hospitalregistry.model.Hospitals;
import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.repositories.HospitalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Date.from;

@Service
@RequiredArgsConstructor
public class HospitalsServicesImpl implements HospitalsServices {
    private final HospitalsRepository hospitalsRepository;

    /**
     * Получить все больницы из БД
     * @return список больниц
     */
    @Override
    public List<Hospitals> getAll() {
        return hospitalsRepository.findAll(); //аналог SELEST * from hospitals;
    }

    @Override
    public HospitalsDto getHospitalById(Long hospitalId) {
        Hospitals hospitals = hospitalsRepository.findById(hospitalId)
                .orElseThrow(PatientNotFoundException::new);

        return from(hospitals);
    }

    private HospitalsDto from(Hospitals hospitals) {
        return HospitalsDto.builder()
                .id(hospitals.getId())
                .hospitalName(hospitals.getHospitalName())
                .hospitalAddress(hospitals.getHospitalAddress())
                .hospitalPhone(String.valueOf(hospitals.getHospitalPhone()))
                .build();
    }

    @Override
    public void deleteHospital(Long id){
        hospitalsRepository.deleteById(id);
    }

    @Override
    public void deleteById(Long id) {

    }
}
