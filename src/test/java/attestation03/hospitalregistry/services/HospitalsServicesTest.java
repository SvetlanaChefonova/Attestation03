package attestation03.hospitalregistry.services;

import attestation03.hospitalregistry.dto.HospitalsDto;
import attestation03.hospitalregistry.model.Hospitals;
import attestation03.hospitalregistry.repositories.HospitalsRepository;
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
@DisplayName(value = "Hospital Service is working when")
@SpringBootTest
public class HospitalsServicesTest {
    @MockBean
    private HospitalsRepository hospitalsRepository;

    @Autowired
    private HospitalsServices hospitalsServices = new HospitalsServicesImpl(hospitalsRepository);
    private final List<Hospitals> hospitals = new ArrayList<>();
    private Hospitals hospitalFirst;
    private Hospitals hospitalSecond;

    @BeforeEach
    public void init() {
        hospitalFirst = new Hospitals();
        hospitalFirst.setId(5L);
        hospitalFirst.setHospitalName("Детская поликлиника");
        hospitalFirst.setHospitalAddress("г. Москва, ул. Кошкина д.5");
        hospitalFirst.setHospitalPhone(88951524758L);

        hospitalSecond = new Hospitals();
        hospitalSecond.setId(6L);
        hospitalSecond.setHospitalName("Взрослая поликлиника");
        hospitalSecond.setHospitalAddress("г. Москва, ул. Ленина д.10");
        hospitalSecond.setHospitalPhone(88951511158L);

        hospitals.add(hospitalFirst);
        hospitals.add(hospitalSecond);
    }

    @Test
    public void returning_hospital_by_Id() {
        Mockito.when(hospitalsRepository.findById(5L)).thenReturn(java.util.Optional.ofNullable(hospitalSecond));
        HospitalsDto found = hospitalsServices.getHospitalById(5L);
        assertNotNull(found);
        Assertions.assertEquals(hospitalSecond.getHospitalName(), found.getHospitalName());
        Assertions.assertEquals(hospitalSecond.getId(), found.getId());
    }

    @Test
    public void hospital_delete_by_Id() {
        hospitalsServices.deleteHospital(hospitalFirst.getId());
        Mockito.verify(hospitalsRepository, Mockito.times(1))
                .deleteById(hospitalFirst.getId());
    }

}
