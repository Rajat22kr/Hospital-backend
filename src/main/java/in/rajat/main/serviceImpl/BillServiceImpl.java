package in.rajat.main.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.entities.Bill;
import in.rajat.main.entities.Patient;
import in.rajat.main.entities.Appointment;
import in.rajat.main.repositories.BillRepository;
import in.rajat.main.repositories.PatientRepository;
import in.rajat.main.repositories.AppointmentRepository;
import in.rajat.main.dto.BillDTO;
import in.rajat.main.service.BillService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    private BillDTO convertToDTO(Bill bill) {
        return BillDTO.builder()
                .id(bill.getId())
                .patientId(bill.getPatient().getPatientId())
                .appointmentId(bill.getAppointment().getId())
                .amount(bill.getAmount())
                .billDate(bill.getBillDate())
                .status(bill.getStatus())
                .build();
    }

    @Override
    public BillDTO create(BillDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Appointment appointment = appointmentRepository.findById(dto.getAppointmentId())
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Bill bill = Bill.builder()
                .patient(patient)
                .appointment(appointment)
                .amount(dto.getAmount())
                .status(dto.getStatus())
                .build();

        return convertToDTO(billRepository.save(bill));
    }

    @Override
    public BillDTO getById(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        return convertToDTO(bill);
    }

    @Override
    public List<BillDTO> getAll() {
        return billRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BillDTO update(Long id, BillDTO dto) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        if (dto.getPatientId() != null) {
            Patient patient = patientRepository.findById(dto.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            bill.setPatient(patient);
        }

        if (dto.getAppointmentId() != null) {
            Appointment appointment = appointmentRepository.findById(dto.getAppointmentId())
                    .orElseThrow(() -> new RuntimeException("Appointment not found"));
            bill.setAppointment(appointment);
        }

        if (dto.getAmount() != 0) bill.setAmount(dto.getAmount());
        if (dto.getStatus() != null) bill.setStatus(dto.getStatus());

        return convertToDTO(billRepository.save(bill));
    }

    @Override
    public void delete(Long id) {
        if (!billRepository.existsById(id))
            throw new RuntimeException("Bill not found");
        billRepository.deleteById(id);
    }
}
