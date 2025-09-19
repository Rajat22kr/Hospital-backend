package in.rajat.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long userId;
    private String name;
    private String password; // For login only
    private String contact;
    private String role;     // ADMIN / DOCTOR / PATIENT
    private String gender;
    private String address;
}

