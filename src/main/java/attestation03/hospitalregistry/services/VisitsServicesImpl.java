package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.VisitsDto;
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
    public List<VisitsDto> getAll() {
        return VisitsDto.from(visitsRepository.findAll()); //аналог SELEST * from visits;
    }

    @Override
    public VisitsDto getVisitById(Long hospitalId) {
        return null;
    }

    @Override
    public void deleteById(Long id){
        visitsRepository.deleteById(id);
    }

    @Override
    public void deleteVisit(Long id){
        visitsRepository.deleteById(id);
    }


}
