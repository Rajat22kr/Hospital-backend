package in.rajat.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.rajat.main.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Optional: find by linked user
    Patient findByUserUserId(Long userId);
}
