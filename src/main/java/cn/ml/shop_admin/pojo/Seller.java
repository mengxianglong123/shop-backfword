package cn.ml.shop_admin.pojo;

public class Seller {
    private int id;
    private String sellerName;
    private double mark;

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", sellerName='" + sellerName + '\'' +
                ", mark=" + mark +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Seller() {
    }

    public Seller(int id, String sellerName, double mark) {
        this.id = id;
        this.sellerName = sellerName;
        this.mark = mark;
    }
}
