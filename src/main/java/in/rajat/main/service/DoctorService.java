package in.rajat.main.service;

import java.util.List;
import in.rajat.main.dto.DoctorDTO;

public interface DoctorService {
    DoctorDTO create(DoctorDTO dto);
    DoctorDTO getById(Long id);
    List<DoctorDTO> getAll();
    DoctorDTO update(Long id, DoctorDTO dto);
    void delete(Long id);
}
