package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.model.Visits;
import attestation03.hospitalregistry.repositories.PatientsRepository;
import attestation03.hospitalregistry.repositories.VisitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitsServicesImpl implements VisitsServices{
    private final VisitsRepository visitsRepository;

    /**
     * Получить все визиты к врачу из БД
     * @return список визитов
     */
    @Override
    public List<Visits> getAll() {
        return visitsRepository.findAll(); //аналог SELEST * from visits;
    }
}
