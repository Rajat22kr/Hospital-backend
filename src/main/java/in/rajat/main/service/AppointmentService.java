package in.rajat.main.service;

import java.util.List;
import in.rajat.main.dto.AppointmentDTO;

public interface AppointmentService {
    AppointmentDTO create(AppointmentDTO dto);
    AppointmentDTO getById(Long id);
    List<AppointmentDTO> getAll();
    AppointmentDTO update(Long id, AppointmentDTO dto);
    void delete(Long id);
}
