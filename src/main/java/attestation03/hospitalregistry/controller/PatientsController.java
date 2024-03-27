package attestation03.hospitalregistry.controller;

import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.dto.PatientsPage;
import attestation03.hospitalregistry.services.PatientsServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



/**
 * localhost:8080/patients
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientsController {

    private final PatientsServices patientsServices;

    /**
     *  HTTP протокол
     *  get - получить данные по ссылке
     */

    //получение всех пациентов если использовать freemarker
    @GetMapping
    public String getPatientsPage(Model model) {
        model.addAttribute("patientsList", patientsServices.getAll());
        return "patients";
    }


   /* public ResponseEntity<PatientsPage> getAllPatientsByPage(int page) {
        return ResponseEntity.ok(patientsServices.getAllPatientsByPage(page));
    }*/

    //получение всех пациентов в формате JSON
    @GetMapping("/getPatients")
    public ResponseEntity<?> getPatients() {
        return ResponseEntity.ok(patientsServices.getAll());
    }

    //получение пациента по id без freemarker, для postman, например, localhost:8080/patients/2
    @GetMapping("/{patient-id}")
    public ResponseEntity<PatientsDto> getPatientById(@PathVariable("patient-id") Long patientId){
           return ResponseEntity
                   .status(HttpStatus.ACCEPTED)
                   .body(patientsServices.getPatientById(patientId));
    }

    //создание нового пациента
    @PostMapping("/add")
    public ResponseEntity<PatientsDto> addPatientByParams(@Valid @RequestParam(name="patientId") Long patientId,
                                                          @Valid @RequestParam(name="lastName") String lastName,
                                                          @Valid @RequestParam(name="name") String name,
                                                          @Valid @RequestParam(name="patronymic") String patronymic ) {
        PatientsDto patientsDto = new PatientsDto();
        patientsDto.setId(patientId);
        patientsDto.setLastName(lastName);
        patientsDto.setName(name);
        patientsDto.setPatronymic(patronymic);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(patientsServices.addPatient(patientsDto));
    }
    @PostMapping
    public ResponseEntity<PatientsDto> addPatient(@Valid @RequestBody PatientsDto patients) {
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(patientsServices.addPatient(patients));
    }


    //изменение данных пациента
    @PutMapping("/{patient-id}")
    public ResponseEntity<PatientsDto> updatePatient(@PathVariable("patient-id") Long patientID,
                                                    @Valid @RequestBody PatientsDto newData) {

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(patientsServices.updatePatient(patientID, newData));

    }

    //удаление пациента жёсткое
    @DeleteMapping("/{patient-id}")
    public ResponseEntity<?> deletePatientById(@PathVariable("patient-id") Long patientId){
        patientsServices.deleteById(patientId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }


    //удаление пациента через soft Delete flag
    @PutMapping("/soft/{patient-id}")
    public ResponseEntity<?> deletePatientSoft(@PathVariable("patient-id") Long patientId){
        patientsServices.softDeleteById(patientId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }



}
