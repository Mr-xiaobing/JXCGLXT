package pojo;

import java.time.LocalDateTime;

/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class StockIn {
    private int stockInNo;
    private int storageNo;
    private int goodsNo;
    private int siQuantity;
    private LocalDateTime siDate;
    private String handler;
    private String siRemark;

    public StockIn() {
        super();
    }

    public StockIn(int stockInNo, int storageNo, int goodsNo, int siQuantity, LocalDateTime siDate, String handler, String siRemark) {
        this.stockInNo = stockInNo;
        this.storageNo = storageNo;
        this.goodsNo = goodsNo;
        this.siQuantity = siQuantity;
        this.siDate = siDate;
        this.handler = handler;
        this.siRemark = siRemark;
    }

    public int getStockInNo() {
        return stockInNo;
    }

    public void setStockInNo(int stockInNo) {
        this.stockInNo = stockInNo;
    }

    public int getStorageNo() {
        return storageNo;
    }

    public void setStorageNo(int storageNo) {
        this.storageNo = storageNo;
    }

    public int getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(int goodsNo) {
        this.goodsNo = goodsNo;
    }

    public int getSiQuantity() {
        return siQuantity;
    }

    public void setSiQuantity(int siQuantity) {
        this.siQuantity = siQuantity;
    }

    public LocalDateTime getSiDate() {
        return siDate;
    }

    public void setSiDate(LocalDateTime siDate) {
        this.siDate = siDate;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getSiRemark() {
        return siRemark;
    }

    public void setSiRemark(String siRemark) {
        this.siRemark = siRemark;
    }
}
