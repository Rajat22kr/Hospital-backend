package in.rajat.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.rajat.main.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Optional: find by linked user
    Doctor findByUserUserId(Long userId);
}
