package exam1.repository;

import exam1.barchart.MonthlySales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalesRepository {
    final static String DB_URL = "jdbc:derby://localhost:1527/Fall2020S1";
    final static String SQL = "SELECT PURCHASEMONTH, PRICEPAID "
                                + "FROM DEVELOPER.SALESBYMONTH";

    public List<MonthlySales> findAll() {
        List<MonthlySales> salesList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = conn.prepareStatement(SQL);
        ) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("PURCHASEMONTH");
                int price = rs.getInt("PRICEPAID");
                MonthlySales c = new MonthlySales(name, price);
                salesList.add(c);
            }

        } catch (Exception ex) {
            System.out.println("General Exception");
            ex.printStackTrace();
        }

        return salesList;
    }
}
