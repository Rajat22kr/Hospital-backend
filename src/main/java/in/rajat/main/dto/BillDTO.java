package in.rajat.main.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDTO {
    private Long id;
    private Long patientId;
    private Long appointmentId;
    private double amount;
    private LocalDateTime billDate;
    private String status;
}

