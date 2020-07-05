package pojo;

import java.time.LocalDateTime;


/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class SalesReturn {

    private int srNo;

    private int goodsNo;

    private int srQuantity;

    private double srPrice;

    private LocalDateTime srDate;

    private String handler;

    private int clientNo;

    private String srRemark;

    private int storageNo;

    public SalesReturn() {
        super();
    }

    public SalesReturn(int srNo, int goodsNo, int srQuantity, double srPrice, LocalDateTime srDate, String handler, int clientNo, String srRemark, int storageNo) {
        this.srNo = srNo;
        this.goodsNo = goodsNo;
        this.srQuantity = srQuantity;
        this.srPrice = srPrice;
        this.srDate = srDate;
        this.handler = handler;
        this.clientNo = clientNo;
        this.srRemark = srRemark;
        this.storageNo = storageNo;
    }

    public int getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(int goodsNo) {
        this.goodsNo = goodsNo;
    }

    public int getSrQuantity() {
        return srQuantity;
    }

    public void setSrQuantity(int srQuantity) {
        this.srQuantity = srQuantity;
    }

    public double getSrPrice() {
        return srPrice;
    }

    public void setSrPrice(double srPrice) {
        this.srPrice = srPrice;
    }

    public LocalDateTime getSrDate() {
        return srDate;
    }

    public void setSrDate(LocalDateTime srDate) {
        this.srDate = srDate;
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

    public int getStorageNo() {
        return storageNo;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getSrRemark() {
        return srRemark;
    }

    public void setSrRemark(String srRemark) {
        this.srRemark = srRemark;
    }

    public void setStorageNo(int storageNo) {
        this.storageNo = storageNo;
    }
}
