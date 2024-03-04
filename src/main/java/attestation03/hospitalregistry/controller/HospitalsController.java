package attestation03.hospitalregistry.controller;

import attestation03.hospitalregistry.services.HospitalsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String getHospitlasPage(Model model) {
        model.addAttribute("hospitals", hospitalsServices.getAll());
        return "hospitals";
    }
}
