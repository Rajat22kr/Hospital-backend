package in.rajat.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.rajat.main.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries later if needed
//    User findByName(String name); // Example: find by username
    Optional<User> findByName(String name);

}
