package in.rajat.main.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.dto.DoctorDTO;
import in.rajat.main.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public DoctorDTO createDoctor(@RequestBody DoctorDTO dto) {
        return doctorService.create(dto);
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctor(@PathVariable Long id) {
        return doctorService.getById(id);
    }

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAll();
    }

    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO dto) {
        return doctorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.delete(id);
        return "Doctor deleted successfully";
    }
}
