package attestation03.hospitalregistry.controller;

import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.services.PatientsServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.EnableMBeanExport;
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

    //@GetMapping("/patients")
    //public String findAll(Model model) {
       // List<Patients>patients=patientsServices.findAll();
       // model.addAttribute("patients", patients);
       // return "patients";
   // }

    //получение всех пациентов
    @GetMapping
    public String getPatientsPage(Model model) {
        model.addAttribute("patientsList", patientsServices.getAll());
        return "patients";
    }


    //получение пациента по id
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
                                                          @Valid @RequestParam(name="patronymic") String patronymic  ) {
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
  //  @PutMapping("/{patients_id}")
  //  public ResponseEntity<PatientsDto> updatePatient(@PathVariable("patient-id")) Long patientId,
                             //           @ResponseBody PatientsDto newData) {

   // }

    //удаление пациента жёсткое
    @DeleteMapping("/{patient-id}")
    public ResponseEntity<?> deletePatientById(@PathVariable("patient-id") Long patientId){
        patientsServices.deleteById(patientId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


    //удаление пациента через soft Delete flag
    @PutMapping("/soft/{patient-id}")
    public ResponseEntity<?> deletePatientSoft(@PathVariable("patient-id") Long patientId){
        patientsServices.softDeleteById(patientId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }






    //@GetMapping("/patient-create")
    //public String createPatientForm(Patients patients){
        //return "patient-create";
    //}



   //@PostMapping("/patient-create")
   //public String createPatient(Patients patients){
    //patientsServices.savePatient(patients);
    // return "redirect:/patients";
  //  }

    //@PutMapping

   //@DeleteMapping

   // @GetMapping("/patient-delete/{id}")
   // public String deletePatient(@PathVariable("id") Long id){
      //  patientsServices.deleteById(id);
      //  return "redirect:/users";
   // }
}
