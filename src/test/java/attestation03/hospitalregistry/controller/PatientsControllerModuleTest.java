package attestation03.hospitalregistry.controller;

import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.dto.PatientsPage;
import attestation03.hospitalregistry.services.PatientsServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.doReturn;

//@ExtendWith(MockitoExtension.class)
public class PatientsControllerModuleTest {
  /*  @Mock
    PatientsServices patientsServices;
    @InjectMocks
    PatientsController patientsController;
    @Test
    @DisplayName("GET /patients возвращает HTTP-ответ со статусом 200 ОК и списком пациентов")
    void getAllPatientsByPage_ReturnsResponseEntity() {

        //given

        List<PatientsDto> patientsDtoList = List.of(
                new PatientsDto(16L, "Викторов", "Валерий", "Николаевич"),
                new PatientsDto(17L, "Николаев", "Владимир", "Александровчи"),
                new PatientsDto(18L, "Гордеев", "Илья", "Николаевич")
        );
        PatientsPage patientsPage = new PatientsPage(
                patientsDtoList,
                3
        );

        doReturn(patientsPage)
                .when(this.patientsServices)
                .getAllPatientsByPage(1);

        //when

        ResponseEntity<PatientsPage> patientsPageResponseEntity =
                this.patientsController.getAllPatientsByPage(1);

        //then

        Assertions.assertNotNull(patientsPageResponseEntity);
        Assertions.assertEquals(HttpStatus.OK, patientsPageResponseEntity.getStatusCode());
        Assertions.assertEquals(MediaType.APPLICATION_JSON, patientsPageResponseEntity.getHeaders().getContentType());
        Assertions.assertEquals(patientsPage, patientsPageResponseEntity.getBody());
    }*/
}
