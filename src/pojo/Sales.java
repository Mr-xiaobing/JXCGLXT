package pojo;

import java.time.LocalDateTime;

/**
 * @author Xbin
 * @date 2020/7/2
 *
 */

public class Sales {
    private int sNo;
    private int goodsNo;
    private int quantitySale;
    private double priceSale;
    private LocalDateTime dateSale;
    private String handler;
    private int clientNo;
    private String sRemark;
    private int storageNo;

    public Sales() {
        super();
    }

    public Sales(int sNo, int goodsNo, int quantitySale, double priceSale, LocalDateTime dateSale, String handler, int clientNo, String sRemark, int storageNo) {
        this.sNo = sNo;
        this.goodsNo = goodsNo;
        this.quantitySale = quantitySale;
        this.priceSale = priceSale;
        this.dateSale = dateSale;
        this.handler = handler;
        this.clientNo = clientNo;
        this.sRemark = sRemark;
        this.storageNo = storageNo;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public int getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(int goodsNo) {
        this.goodsNo = goodsNo;
    }

    public int getQuantitySale() {
        return quantitySale;
    }

    public void setQuantitySale(int quantitySale) {
        this.quantitySale = quantitySale;
    }

    public double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }

    public LocalDateTime getDateSale() {
        return dateSale;
    }

    public void setDateSale(LocalDateTime dateSale) {
        this.dateSale = dateSale;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public String getsRemark() {
        return sRemark;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark;
    }

    public int getStorageNo() {
        return storageNo;
    }

    public void setStorageNo(int storageNo) {
        this.storageNo = storageNo;
    }
}
