package in.rajat.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.rajat.main.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    // Optional: find all bills for a patient
    List<Bill> findByPatientPatientId(Long patientId);

    // Optional: find bill by appointment
    Bill findByAppointmentId(Long appointmentId);
}
