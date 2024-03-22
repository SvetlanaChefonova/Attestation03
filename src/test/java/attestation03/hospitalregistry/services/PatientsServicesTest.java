package attestation03.hospitalregistry.services;

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

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName(value = "Patient Service is working when")
@SpringBootTest
class PatientsServicesTest {
    @MockBean
    private PatientsRepository patientsRepository;

    @Autowired
    private PatientsServices patientsServices = new PatientsServicesImpl(patientsRepository);
    private final List<Patients> patients = new ArrayList<>();
    private Patients patientsFirst;

    @BeforeEach
    public void init() {
        patientsFirst = new Patients();
        patientsFirst.setId(10L);
        patientsFirst.setLastName("Степанов");
        patientsFirst.setName("Александр");
        patientsFirst.setPatronymic("Сергеевич");

        patients.add(patientsFirst);
    }

   /* @Test
    public void returning_patients_by_id() {
        Mockito.when(patientsRepository.findById(10L)).thenReturn(java.util.Optional.ofNullable(patientsFirst));
        Patients found = patientsServices.getPatientById(10));
        assertNotNull(found);
        Assertions.assertEquals(patientsFirst.getId(), found.getId());
        Assertions.assertEquals(patientsFirst.getLastName(), found.getLastName());
        Assertions.assertEquals(patientsFirst.getName(), found.getName());
        Assertions.assertEquals(patientsFirst.getPatronymic(), found.getPatronymic());


    }*/

}
