package in.rajat.main.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.dto.BillDTO;
import in.rajat.main.service.BillService;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping
    public BillDTO createBill(@RequestBody BillDTO dto) {
        return billService.create(dto);
    }

    @GetMapping("/{id}")
    public BillDTO getBill(@PathVariable Long id) {
        return billService.getById(id);
    }

    @GetMapping
    public List<BillDTO> getAllBills() {
        return billService.getAll();
    }

    @PutMapping("/{id}")
    public BillDTO updateBill(@PathVariable Long id, @RequestBody BillDTO dto) {
        return billService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        billService.delete(id);
        return "Bill deleted successfully";
    }
}
