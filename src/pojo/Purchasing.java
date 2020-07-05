package pojo;

import java.time.LocalDateTime;

/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class Purchasing {
    private int pNo;
    private int goodsNo;
    private int quantityIn;
    private double priceIn;
    private LocalDateTime dateIn;
    private String handler;
    private String pRemark;
    private int storageNo;

    public Purchasing() {
        super();
    }

    public Purchasing(int pNo, int goodsNo, int quantityIn, double priceIn, LocalDateTime dateIn, String handler, String pRemark, int storageNo) {
        this.pNo = pNo;
        this.goodsNo = goodsNo;
        this.quantityIn = quantityIn;
        this.priceIn = priceIn;
        this.dateIn = dateIn;
        this.handler = handler;
        this.pRemark = pRemark;
        this.storageNo = storageNo;
    }

    public int getpNo() {
        return pNo;
    }

    public void setpNo(int pNo) {
        this.pNo = pNo;
    }

    public int getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(int goodsNo) {
        this.goodsNo = goodsNo;
    }

    public int getQuantityIn() {
        return quantityIn;
    }

    public void setQuantityIn(int quantityIn) {
        this.quantityIn = quantityIn;
    }

    public double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(double priceIn) {
        this.priceIn = priceIn;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDateTime dateIn) {
        this.dateIn = dateIn;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark;
    }

    public int getStorageNo() {
        return storageNo;
    }

    public void setStorageNo(int storageNo) {
        this.storageNo = storageNo;
    }
}
