package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.DoctorsDto;
import attestation03.hospitalregistry.model.Doctors;
import attestation03.hospitalregistry.repositories.DoctorsRepository;
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
@DisplayName(value = "Doctor Service is working when")
@SpringBootTest
public class DoctorsServicesTest {
    @MockBean
    private DoctorsRepository doctorsRepository;

    @Autowired
    private DoctorsServices doctorsServices = new DoctorsServicesImpl(doctorsRepository);
    private final List<Doctors> doctors = new ArrayList<>();
    private Doctors doctorFirst;
    private Doctors doctorSecond;

    @BeforeEach
    public void init() {
        doctorFirst = new Doctors();
        doctorFirst.setId(5L);
        doctorFirst.setLastName("Куцева");
        doctorFirst.setName("Светлана");
        doctorFirst.setPatronymic("Анатольевна");
        doctorFirst.setSpecialization("Педиатр");

        doctorSecond = new Doctors();
        doctorSecond.setId(6L);
        doctorSecond.setLastName("Малахова");
        doctorSecond.setName("Лидия");
        doctorSecond.setPatronymic("Леонидовна");
        doctorSecond.setSpecialization("Невролог");

        doctors.add(doctorFirst);
        doctors.add(doctorSecond);
    }

    @Test
    public void returning_doctor_by_Id() {
        Mockito.when(doctorsRepository.findById(5L)).thenReturn(java.util.Optional.ofNullable(doctorSecond));
        DoctorsDto found = doctorsServices.getDoctorById(5L);
        assertNotNull(found);
        Assertions.assertEquals(doctorSecond.getLastName(), found.getLastName());
        Assertions.assertEquals(doctorSecond.getId(), found.getId());
    }

    @Test
    public void doctor_delete_by_Id() {
        doctorsServices.deleteDoctor(doctorFirst.getId());
        Mockito.verify(doctorsRepository, Mockito.times(1))
                .deleteById(doctorFirst.getId());
    }
}

