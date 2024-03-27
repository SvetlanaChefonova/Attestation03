package attestation03.hospitalregistry.controller;


import attestation03.hospitalregistry.dto.HospitalsDto;
import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.dto.VisitsDto;
import attestation03.hospitalregistry.model.Patients;
import attestation03.hospitalregistry.model.Visits;
import attestation03.hospitalregistry.services.VisitsServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * localhost:8080/visits
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitsController {
    private final VisitsServices visitsServices;

    /**
     *  HTTP протокол
     *  get - получить данные по ссылке
     */

    //получение всех записей к врачу если использовать freemarker
    @GetMapping
    public String getVisitsPage(Model model) {
        model.addAttribute("visitsList", visitsServices.getAll());
        return "visits";
    }


    //получение всех записей к врачу  формате JSON
    @GetMapping("/getVisits")
    public ResponseEntity<?> getVisits() {
        return ResponseEntity.ok(visitsServices.getAll());
    }

    //получение записи к врачу по id
    @GetMapping("/{visit-id}")
    public ResponseEntity<VisitsDto> getVisitById(@PathVariable("visit-id") Long hospitalId){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(visitsServices.getVisitById(hospitalId));
    }

    // добавление новой записи к врачу

    // изменение записи к врачу

    //удаление записи к врачу
    @DeleteMapping("/{visit-id}")
    public ResponseEntity<?> deleteVisitById(@PathVariable("visit-id") Long visitId){
        visitsServices.deleteById(visitId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}

