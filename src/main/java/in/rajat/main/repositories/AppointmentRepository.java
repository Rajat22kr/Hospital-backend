package in.rajat.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.rajat.main.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Optional: find all appointments for a patient
    List<Appointment> findByPatientPatientId(Long patientId);

    // Optional: find all appointments for a doctor
    List<Appointment> findByDoctorDoctorId(Long doctorId);
}
