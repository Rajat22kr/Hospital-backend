package in.rajat.main.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.dto.AppointmentDTO;
import in.rajat.main.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO createAppointment(@RequestBody AppointmentDTO dto) {
        return appointmentService.create(dto);
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointment(@PathVariable Long id) {
        return appointmentService.getById(id);
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAll();
    }

    @PutMapping("/{id}")
    public AppointmentDTO updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO dto) {
        return appointmentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
        return "Appointment deleted successfully";
    }
}
