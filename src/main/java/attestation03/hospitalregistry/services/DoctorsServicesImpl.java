package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.model.Doctors;
import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.repositories.DoctorsRepository;
import attestation03.hospitalregistry.repositories.PatientsRepository;
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
}
