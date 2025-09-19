package in.rajat.main.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.entities.Patient;
import in.rajat.main.entities.User;
import in.rajat.main.repositories.PatientRepository;
import in.rajat.main.repositories.UserRepository;
import in.rajat.main.dto.PatientDTO;
import in.rajat.main.service.PatientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    private PatientDTO convertToDTO(Patient patient) {
        return PatientDTO.builder()
                .patientId(patient.getPatientId())
                .userId(patient.getUser().getUserId())
                .age(patient.getAge())
                .build();
    }

    @Override
    public PatientDTO create(PatientDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Patient patient = Patient.builder()
                .user(user)
                .age(dto.getAge())
                .build();
        return convertToDTO(patientRepository.save(patient));
    }

    @Override
    public PatientDTO getById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return convertToDTO(patient);
    }

    @Override
    public List<PatientDTO> getAll() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO update(Long id, PatientDTO dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        if (dto.getAge() != null) patient.setAge(dto.getAge());
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            patient.setUser(user);
        }

        return convertToDTO(patientRepository.save(patient));
    }

    @Override
    public void delete(Long id) {
        if (!patientRepository.existsById(id))
            throw new RuntimeException("Patient not found");
        patientRepository.deleteById(id);
    }
}
