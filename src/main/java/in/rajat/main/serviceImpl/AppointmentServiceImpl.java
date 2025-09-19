package in.rajat.main.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.entities.Appointment;
import in.rajat.main.entities.Patient;
import in.rajat.main.entities.Doctor;
import in.rajat.main.repositories.AppointmentRepository;
import in.rajat.main.repositories.PatientRepository;
import in.rajat.main.repositories.DoctorRepository;
import in.rajat.main.dto.AppointmentDTO;
import in.rajat.main.service.AppointmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    private AppointmentDTO convertToDTO(Appointment appointment) {
        return AppointmentDTO.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatient().getPatientId())
                .doctorId(appointment.getDoctor().getDoctorId())
                .appointmentDate(appointment.getAppointmentDate())
                .status(appointment.getStatus())
                .build();
    }

    @Override
    public AppointmentDTO create(AppointmentDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = Appointment.builder()
                .patient(patient)
                .doctor(doctor)
                .appointmentDate(dto.getAppointmentDate())
                .status(dto.getStatus())
                .build();

        return convertToDTO(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentDTO getById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return convertToDTO(appointment);
    }

    @Override
    public List<AppointmentDTO> getAll() {
        return appointmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO update(Long id, AppointmentDTO dto) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        if (dto.getPatientId() != null) {
            Patient patient = patientRepository.findById(dto.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            appointment.setPatient(patient);
        }

        if (dto.getDoctorId() != null) {
            Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            appointment.setDoctor(doctor);
        }

        if (dto.getAppointmentDate() != null)
            appointment.setAppointmentDate(dto.getAppointmentDate());

        if (dto.getStatus() != null)
            appointment.setStatus(dto.getStatus());

        return convertToDTO(appointmentRepository.save(appointment));
    }

    @Override
    public void delete(Long id) {
        if (!appointmentRepository.existsById(id))
            throw new RuntimeException("Appointment not found");
        appointmentRepository.deleteById(id);
    }
}
