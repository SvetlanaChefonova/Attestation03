package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.exception.PatientNotFoundException;
import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.repositories.PatientsRepository;
import org.checkerframework.checker.units.qual.A;
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

import static java.util.Date.from;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName(value = "Patient Service is working when")
@SpringBootTest
class PatientsServicesTest {
    @MockBean
    private PatientsRepository patientsRepositoryMock;

    @Autowired
    private PatientsServices patientsServices = new PatientsServicesImpl(patientsRepositoryMock);
    private final List<PatientsDto> patients = new ArrayList<>();
    private PatientsDto patientsFirst;
    private PatientsDto patientsSecond;

    @BeforeEach
    public void init() {
        patientsFirst = new PatientsDto();
        patientsFirst.setId(20L);
        patientsFirst.setLastName("Степанов");
        patientsFirst.setName("Александр");
        patientsFirst.setPatronymic("Сергеевич");

        patientsSecond = new PatientsDto();
        patientsSecond.setId(25L);
        patientsSecond.setLastName("Козлов");
        patientsSecond.setName("Игорь");
        patientsSecond.setPatronymic("Игоревич");
        //patientsRepositoryMock.save(patientsFirst);
        //patientsRepositoryMock.save(patientsSecond);
        patients.add(patientsFirst);
        patients.add(patientsSecond);
    }

  /*  @Test
    public void returning_patients_by_id() {
        Assertions.assertThrows(PatientNotFoundException.class, ()->{
            Mockito.when(
                    from(patientsRepositoryMock.findById(10L)).orElseThrow(PatientNotFoundException::new)
            ).thenReturn(patientsSecond);
        });
        PatientsDto found = patientsServices.getPatientById(Long.valueOf(20));

        assertNotNull(found);

        Assertions.assertEquals(patientsFirst.getId(), found.getId());
        Assertions.assertEquals(patientsFirst.getLastName(), found.getLastName());
        Assertions.assertEquals(patientsFirst.getName(), found.getName());
        Assertions.assertEquals(patientsFirst.getPatronymic(), found.getPatronymic());


    }*/


    @Test
    public void delete_patients_by_id() {
        patientsServices.deletePatient(patientsFirst.getId());
        Mockito.verify(patientsRepositoryMock, Mockito.times(1))
                .deleteById(patientsFirst.getId());
    }

}
