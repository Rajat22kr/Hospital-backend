package in.rajat.main.service;

import java.util.List;
import in.rajat.main.dto.BillDTO;

public interface BillService {
    BillDTO create(BillDTO dto);
    BillDTO getById(Long id);
    List<BillDTO> getAll();
    BillDTO update(Long id, BillDTO dto);
    void delete(Long id);
}
