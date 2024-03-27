package attestation03.hospitalregistry.repository;


import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.repositories.PatientsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Optional;
@DisplayName(value = "Patient Repository is working when")
@DataJpaTest
public class PatientsRepositoryTest {
    @Autowired
    private PatientsRepository patientsRepository;

    @Test
    public void should_save_and_fetch_patient() {
        Patients newPatients = new Patients();
        newPatients.setId(Long.valueOf("55L"));
        newPatients.setLastName("Васичкин");
        newPatients.setName("Петр");
        newPatients.setPatronymic("Леонидович");
        patientsRepository.save(newPatients);

        Optional<Patients> maybeNewPatient = patientsRepository.findById(newPatients.getId());
        assertThat(maybeNewPatient.get().getLastName(), is(newPatients.getLastName()));
    }
    @AfterEach
    public void tearDown() {
        patientsRepository.deleteAll();
    }
}
