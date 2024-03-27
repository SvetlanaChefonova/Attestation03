package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.DoctorsDto;
import attestation03.hospitalregistry.exception.DoctorNotFoundException;
import attestation03.hospitalregistry.model.Doctors;
import attestation03.hospitalregistry.repositories.DoctorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorsServicesImpl implements DoctorsServices{
    private final DoctorsRepository doctorsRepository;

    /**
     * Получить всех докторов из БД
     * @return список докторов
     */
    @Override
    public List<Doctors> getAll() {
        return doctorsRepository.findAll(); //аналог SELEST * from doctors;
    }

    @Override
    public DoctorsDto getDoctorById(Long doctorId) {
        Doctors doctors = doctorsRepository.findById(doctorId)
                .orElseThrow(DoctorNotFoundException::new);

        return from(doctors);
    }

    private DoctorsDto from(Doctors doctors) {
        return DoctorsDto.builder()
                .id(doctors.getId())
                .lastName(doctors.getLastName())
                .name(doctors.getName())
                .patronymic(doctors.getPatronymic())
                .specialization(doctors.getSpecialization())
                .cabinetNumber(doctors.getCabinetNumber())
                .build();
    }

    @Override
    public void deleteDoctor(Long id){
        doctorsRepository.deleteById(id);
    }

    @Override
    public void deleteById(Long id) {

    }
}
