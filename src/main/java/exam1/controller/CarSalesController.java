package exam1.controller;

import exam1.barchart.MonthlySales;
import exam1.repository.SalesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CarSalesController {

    SalesRepository repository = new SalesRepository();

    @GetMapping("/design/monthlysales")
    public List<MonthlySales> getMonthlySales() {
        return repository.findAll();
    }

    @GetMapping("/db/monthlysales")
    public List<MonthlySales> getDbMonthlySales() {
        return repository.findAll();
    }

}

