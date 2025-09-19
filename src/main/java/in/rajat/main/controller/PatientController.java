package in.rajat.main.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.dto.PatientDTO;
import in.rajat.main.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientDTO dto) {
        return patientService.create(dto);
    }

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable Long id) {
        return patientService.getById(id);
    }

    @GetMapping
    public List<PatientDTO> getAllPatients() {
        return patientService.getAll();
    }

    @PutMapping("/{id}")
    public PatientDTO updatePatient(@PathVariable Long id, @RequestBody PatientDTO dto) {
        return patientService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.delete(id);
        return "Patient deleted successfully";
    }
}
