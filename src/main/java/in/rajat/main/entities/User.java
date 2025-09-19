package in.rajat.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
    @Column(name = "user_name", nullable = false, unique = true, length = 50)
	private String name;
    
    @Column(nullable = false)
	private String password;
    
    @Column(length = 15)
	private String contact;
    
    @Column(nullable = false)
	private String role;
    
    @Column(length = 10)
	private String gender;
    
    
    private String address;

}
