package cn.ml.shop_admin.pojo;

public class Goods {
    private int id;
    private String goodsName;
    private double price;
    private String info;
    private int sellerId;
    private Seller seller;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", sellerId=" + sellerId +
                ", seller=" + seller +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Goods() {
    }

    public Goods(int id, String goodsName, double price, String info, int sellerId, Seller seller) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.info = info;
        this.sellerId = sellerId;
        this.seller = seller;
    }
}
