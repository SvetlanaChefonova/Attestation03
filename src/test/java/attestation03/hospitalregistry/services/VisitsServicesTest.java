package attestation03.hospitalregistry.services;


import attestation03.hospitalregistry.dto.VisitsDto;
import attestation03.hospitalregistry.model.Visits;
import attestation03.hospitalregistry.repositories.VisitsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//интеграционный тест
@DisplayName(value = "Visit Service is working when")
@SpringBootTest
public class VisitsServicesTest {
    @MockBean
    private VisitsRepository visitsRepository;

    @Autowired
    private VisitsServices visitsServices = new VisitsServicesImpl(visitsRepository);
    private final List<Visits> visits = new ArrayList<>();
    private Visits visitFirst;
    private Visits visitSecond;

    @BeforeEach
    public void init() {
        visitFirst = new Visits();
        visitFirst.setId(11L);
        visitFirst.setDataTimeOfTheVisit("08.04.2024 15.30");
        visitFirst.getPatients().setLastName("Королева");
        visitFirst.getPatients().setName("Ангелина");
        visitFirst.getPatients().setPatronymic("Сергеевна");
        visitFirst.getDoctors().setLastName("Иванова");
        visitFirst.getDoctors().setLastName("Анна");
        visitFirst.getDoctors().setPatronymic("Григорьевна");
        visitFirst.getDoctors().setSpecialization("Терапевт");
        visitFirst.getHospitals().setHospitalName("Областная больница №4");

        visitSecond = new Visits();
        visitSecond.setId(12L);
        visitSecond.setDataTimeOfTheVisit("09.04.2024 16.30");
        visitSecond.getPatients().setLastName("Малинина");
        visitSecond.getPatients().setName("Кира");
        visitSecond.getPatients().setPatronymic("Андреевна");
        visitSecond.getDoctors().setLastName("Петровский");
        visitSecond.getDoctors().setLastName("Константин");
        visitSecond.getDoctors().setPatronymic("Александрович");
        visitSecond.getDoctors().setSpecialization("Хирург");
        visitSecond.getHospitals().setHospitalName("Областная больница №9");


        visits.add(visitFirst);
        visits.add(visitSecond);
    }

    @Test
    public void returning_visit_by_Id() {
        Mockito.when(visitsRepository.findById(11L)).thenReturn(java.util.Optional.ofNullable(visitSecond));
        VisitsDto found = visitsServices.getVisitById(11L);
        assertNotNull(found);
        Assertions.assertEquals(visitSecond.getDataTimeOfTheVisit(), found.getDataTimeOfTheVisit());
        Assertions.assertEquals(visitSecond.getId(), found.getId());
    }

    @Test
    public void visit_delete_by_Id() {
       visitsServices.deleteVisit(visitFirst.getId());
        Mockito.verify(visitsRepository, Mockito.times(1))
                .deleteById(visitFirst.getId());
    }

}
