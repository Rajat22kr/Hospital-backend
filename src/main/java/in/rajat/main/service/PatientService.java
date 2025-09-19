package in.rajat.main.service;

import java.util.List;
import in.rajat.main.dto.PatientDTO;

public interface PatientService {
    PatientDTO create(PatientDTO dto);
    PatientDTO getById(Long id);
    List<PatientDTO> getAll();
    PatientDTO update(Long id, PatientDTO dto);
    void delete(Long id);
}
