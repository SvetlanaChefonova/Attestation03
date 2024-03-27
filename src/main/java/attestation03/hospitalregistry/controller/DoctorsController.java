package attestation03.hospitalregistry.controller;


import attestation03.hospitalregistry.dto.DoctorsDto;
import attestation03.hospitalregistry.dto.HospitalsDto;
import attestation03.hospitalregistry.services.DoctorsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * localhost:8080/doctors
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorsController {
    private final DoctorsServices doctorsServices;

    /**
     *  HTTP протокол
     *  get - получить данные по ссылке
     */

    //получение всех докторов если использовать freemarker
    @GetMapping
    public String getDoctorsPage(Model model) {
        model.addAttribute("doctorsList", doctorsServices.getAll());
        return "doctors";
    }

    //получение всех докторов в формате JSON
    @GetMapping("/getDoctors")
    public ResponseEntity<?> getDoctors() {
        return ResponseEntity.ok(doctorsServices.getAll());
    }

    //получение доктора по id
    @GetMapping("/{doctor-id}")
    public ResponseEntity<DoctorsDto> getDoctorById(@PathVariable("doctor-id") Long doctorId){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(doctorsServices.getDoctorById(doctorId));
    }

    //удаление доктора
    @DeleteMapping("/{doctor-id}")
    public ResponseEntity<?> deleteDoctorById(@PathVariable("doctor-id") Long doctorId){
        doctorsServices.deleteById(doctorId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}
