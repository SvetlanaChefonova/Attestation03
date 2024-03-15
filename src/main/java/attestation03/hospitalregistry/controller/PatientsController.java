package attestation03.hospitalregistry.controller;

import attestation03.hospitalregistry.services.PatientsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping
    public String getPatientsPage(Model model) {
        model.addAttribute("patientsList", patientsServices.getAll());
        return "patients";
    }

  //  @GetMapping("/patient-create")
   // public String createPatientForm(Patients patients){
        //return "patient-create";
    //}

   // @PostMapping("/patient-create")
   // public String createPatient(Patients patients){
        //patientsServices.savePatient(patients);
       // return "redirect:/patients";
  //  }

    // @PutMapping

   // @DeleteMapping

   // @GetMapping("/patient-delete/{id}")
   // public String deletePatient(@PathVariable("id") Long id){
      //  patientsServices.deleteById(id);
      //  return "redirect:/users";
   // }
}
