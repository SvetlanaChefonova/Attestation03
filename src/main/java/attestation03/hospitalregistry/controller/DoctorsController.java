package attestation03.hospitalregistry.controller;


import attestation03.hospitalregistry.services.DoctorsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String getDoctorsPage(Model model) {
        model.addAttribute("doctors", doctorsServices.getAll());
        return "doctors";
    }
}
