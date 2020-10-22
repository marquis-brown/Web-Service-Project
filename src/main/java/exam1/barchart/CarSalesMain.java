package exam1.barchart;

import com.google.gson.reflect.TypeToken;
import com.jbbwebsolutions.http.utility.URLUtility;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class CarSalesMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String URL = "http://localhost:9416/design/monthlysales";
        //String URL = "http://localhost:9416/db/monthlysales";

        Type listType = new TypeToken<List<MonthlySales>>() {}.getType();
        List<MonthlySales> salesList = URLUtility.get(URL, listType);

        primaryStage.setTitle("Brown, Marquis " + new Date());

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        final BarChart<String,Number> barChart = new BarChart<>(xAxis,yAxis);
        barChart.setTitle("Car Sales");

        for (MonthlySales sale : salesList) {
            XYChart.Series tempBar = new XYChart.Series();
            tempBar.getData().add(new XYChart.Data(sale.getMonth(), sale.getSales()));
            barChart.getData().add(tempBar);
        }

        StackPane pane = new StackPane(barChart);
        Scene scene = new Scene(pane, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
