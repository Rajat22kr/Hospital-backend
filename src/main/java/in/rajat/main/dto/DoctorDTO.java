package in.rajat.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDTO {
    private Long doctorId;
    private Long userId;  // Linked User
    private String specialization;
    private int experience;
    private String qualification;
}
