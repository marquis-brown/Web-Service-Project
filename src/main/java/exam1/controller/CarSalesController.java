package exam1.controller;

import exam1.barchart.MonthlySales;
import exam1.repository.SalesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CarSalesController {

    SalesRepository repository = new SalesRepository();

    @GetMapping("/db/monthlysales")
    public List<MonthlySales> getDbMonthlySales() {
        return repository.findAll();
    }

    @GetMapping("/design/monthlysales")
    public List<MonthlySales> getStaticMonthlySales() {
        List<MonthlySales> sales = new ArrayList<>();
        sales.add(new MonthlySales("Jan",60061));
        sales.add(new MonthlySales("Feb",12113));
        sales.add(new MonthlySales("Mar",147282));
        sales.add(new MonthlySales("Apr",79106));
        sales.add(new MonthlySales("May",172788));
        sales.add(new MonthlySales("June",118845));
        sales.add(new MonthlySales("July",174888));
        sales.add(new MonthlySales("Aug",67210));
        sales.add(new MonthlySales("Sep",120220));
        sales.add(new MonthlySales("Oct",190218));
        sales.add(new MonthlySales("Nov",139784));
        sales.add(new MonthlySales("Dec",184206));

        return sales;
    }

}


