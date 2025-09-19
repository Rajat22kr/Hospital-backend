package in.rajat.main.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.entities.Doctor;
import in.rajat.main.entities.User;
import in.rajat.main.repositories.DoctorRepository;
import in.rajat.main.repositories.UserRepository;
import in.rajat.main.dto.DoctorDTO;
import in.rajat.main.service.DoctorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    private DoctorDTO convertToDTO(Doctor doctor) {
        return DoctorDTO.builder()
                .doctorId(doctor.getDoctorId())
                .userId(doctor.getUser().getUserId())
                .specialization(doctor.getSpecialization())
                .experience(doctor.getExperience())
                .qualification(doctor.getQualification())
                .build();
    }

    @Override
    public DoctorDTO create(DoctorDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Doctor doctor = Doctor.builder()
                .user(user)
                .specialization(dto.getSpecialization())
                .experience(dto.getExperience())
                .qualification(dto.getQualification())
                .build();
        return convertToDTO(doctorRepository.save(doctor));
    }

    @Override
    public DoctorDTO getById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        return convertToDTO(doctor);
    }

    @Override
    public List<DoctorDTO> getAll() {
        return doctorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO update(Long id, DoctorDTO dto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        if (dto.getSpecialization() != null) doctor.setSpecialization(dto.getSpecialization());
        if (dto.getExperience() != 0) doctor.setExperience(dto.getExperience());
        if (dto.getQualification() != null) doctor.setQualification(dto.getQualification());
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            doctor.setUser(user);
        }

        return convertToDTO(doctorRepository.save(doctor));
    }

    @Override
    public void delete(Long id) {
        if (!doctorRepository.existsById(id))
            throw new RuntimeException("Doctor not found");
        doctorRepository.deleteById(id);
    }
}
