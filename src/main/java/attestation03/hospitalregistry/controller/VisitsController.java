package attestation03.hospitalregistry.controller;


import attestation03.hospitalregistry.dto.PatientsDto;
import attestation03.hospitalregistry.dto.VisitsDto;
import attestation03.hospitalregistry.services.VisitsServices;
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

    @DeleteMapping("/{visit-id}")
    public ResponseEntity<?> deleteVisitById(@PathVariable("visit-id") Long visitId){
        visitsServices.deleteById(visitId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}

