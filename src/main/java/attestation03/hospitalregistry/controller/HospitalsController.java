package attestation03.hospitalregistry.controller;

import attestation03.hospitalregistry.dto.HospitalsDto;
import attestation03.hospitalregistry.services.HospitalsServices;
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
 * localhost:8080/hospitals
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalsController {
    private final HospitalsServices hospitalsServices;

    /**
     *  HTTP протокол
     *  get - получить данные по ссылке
     */

    //получение всех больниц если использовать freemarker
    @GetMapping
    public String getHospitalsPage(Model model) {
        model.addAttribute("hospitalsList", hospitalsServices.getAll());
        return "hospitals";
    }

    //получение всех больниц в формате JSON
    @GetMapping("/getHospitals")
    public ResponseEntity<?> getHospitals() {
        return ResponseEntity.ok(hospitalsServices.getAll());
    }

    //получение больницы по id
    @GetMapping("/{hospital-id}")
    public ResponseEntity<HospitalsDto> getHospitalById(@PathVariable("hospital-id") Long hospitalId){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(hospitalsServices.getHospitalById(hospitalId));
    }

    //удаление больницы
    @DeleteMapping("/{hospital-id}")
    public ResponseEntity<?> deleteHospitalById(@PathVariable("hospital-id") Long hospitalId){
        hospitalsServices.deleteById(hospitalId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}
