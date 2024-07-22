package ma.enset.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String Patients(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patients = patientRepository.findByNomContains(keyword, PageRequest.of(0, 5));
        model.addAttribute("ListePatients", patients.getContent());
        return "patients";
    }

   /* @GetMapping(path = "/index")
    public String Patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size) {
        Page<Patient> patientPage = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("listePatients", patientPage.getContent());
        return "patients";
    }*/
   @GetMapping(path = "/delete")

   public String delete(Long id) {
       patientRepository.deleteById(id);
        return "redirect:/index";

   }
   @GetMapping(path ="/")
    public String home() {

       return "redirect:/index";
    }
    @GetMapping(path = "/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }
    @GetMapping(path = "/Authentification")
    public String formPatient(Model model) {

       return "Authentification";
    }

    @PostMapping  (path = "/save")
    public String save(Model model, Patient patient){
        patientRepository.save(patient) ;
        return "redirect:/formPatients";

    }
    /*@GetMapping(path = "/login")
    public String login(Model model) {

        return "patients";
    }*/
    @GetMapping(path = "/edit")
    public String editPatients(Model model, @RequestParam long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) {
            throw new RuntimeException("Patient introuvable");
        }
        model.addAttribute("patient", patient);
        return "editPatients";
    }
    /*@PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("code") String code,
                        Model model) {
        Patient patient = patientRepository.findByNom(code);

        if (patient != null && patient.getCode().equals(code)) {
            return "redirect:/index"; // Redirection vers la page de tableau de bord, par exemple
        } else {
            model.addAttribute("error", "Invalid username or code");
            return "Authentification";
        }*/
    }


