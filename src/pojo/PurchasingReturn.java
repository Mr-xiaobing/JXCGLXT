package pojo;

import java.time.LocalDateTime;


/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class PurchasingReturn {
    private int prNo;
    private int goodsNo;
    private int prQuantity;
    private double prPrice;
    private LocalDateTime prDate;
    private String handler;
    private String prRemark;
    private int storageNo;

    public PurchasingReturn() {
        super();
    }

    public PurchasingReturn(int prNo, int goodsNo, int prQuantity, double prPrice, LocalDateTime prDate, String handler, String prRemark, int storageNo) {
        this.prNo = prNo;
        this.goodsNo = goodsNo;
        this.prQuantity = prQuantity;
        this.prPrice = prPrice;
        this.prDate = prDate;
        this.handler = handler;
        this.prRemark = prRemark;
        this.storageNo = storageNo;
    }

    public int getPrNo() {
        return prNo;
    }

    public void setPrNo(int prNo) {
        this.prNo = prNo;
    }

    public int getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(int goodsNo) {
        this.goodsNo = goodsNo;
    }

    public int getPrQuantity() {
        return prQuantity;
    }

    public void setPrQuantity(int prQuantity) {
        this.prQuantity = prQuantity;
    }

    public double getPrPrice() {
        return prPrice;
    }

    public void setPrPrice(double prPrice) {
        this.prPrice = prPrice;
    }

    public LocalDateTime getPrDate() {
        return prDate;
    }

    public void setPrDate(LocalDateTime prDate) {
        this.prDate = prDate;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getPrRemark() {
        return prRemark;
    }

    public void setPrRemark(String prRemark) {
        this.prRemark = prRemark;
    }

    public int getStorageNo() {
        return storageNo;
    }

    public void setStorageNo(int storageNo) {
        this.storageNo = storageNo;
    }
}
