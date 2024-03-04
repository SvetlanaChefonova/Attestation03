package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.model.Hospitals;
import attestation03.hospitalregistry.repositories.HospitalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
