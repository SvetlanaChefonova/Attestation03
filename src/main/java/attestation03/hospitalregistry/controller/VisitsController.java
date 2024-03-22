package attestation03.hospitalregistry.controller;


import attestation03.hospitalregistry.services.VisitsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String getVisitsPage(Model model) {
        model.addAttribute("visitsList", visitsServices.getAll());
        return "visits";
    }
}

