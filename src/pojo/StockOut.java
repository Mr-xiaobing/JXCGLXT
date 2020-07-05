package pojo;

import java.time.LocalDateTime;


/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class StockOut {
    private int stockOutNo;
    private int storageNo;
    private int goodsNo;
    private int soQuantity;
    private LocalDateTime soDate;
    private String handler;
    private String soRemark;

    public StockOut() {
        super();
    }

    public StockOut(int stockOutNo, int storageNo, int goodsNo, int soQuantity, LocalDateTime soDate, String handler, String soRemark) {
        this.stockOutNo = stockOutNo;
        this.storageNo = storageNo;
        this.goodsNo = goodsNo;
        this.soQuantity = soQuantity;
        this.soDate = soDate;
        this.handler = handler;
        this.soRemark = soRemark;
    }

    public int getStockOutNo() {
        return stockOutNo;
    }

    public void setStockOutNo(int stockOutNo) {
        this.stockOutNo = stockOutNo;
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

    public int getSoQuantity() {
        return soQuantity;
    }

    public void setSoQuantity(int soQuantity) {
        this.soQuantity = soQuantity;
    }

    public LocalDateTime getSoDate() {
        return soDate;
    }

    public void setSoDate(LocalDateTime soDate) {
        this.soDate = soDate;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getSoRemark() {
        return soRemark;
    }

    public void setSoRemark(String soRemark) {
        this.soRemark = soRemark;
    }
}
