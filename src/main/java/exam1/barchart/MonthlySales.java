package exam1.barchart;

public class MonthlySales {
    private String month;
    private int sales;

    public MonthlySales(String month, int sales) {
        this.month = month;
        this.sales = sales;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Product {" +
                "month='" + month + '\'' +
                ", sales=" + sales +
                '}';
    }
}
