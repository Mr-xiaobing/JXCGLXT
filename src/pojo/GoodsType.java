package pojo;

import java.time.LocalDateTime;


/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class GoodsType {

    private int typeNo;

    private String type;

    private LocalDateTime createTime;

    public GoodsType() {
        super();
    }

    public GoodsType(int typeNo, String type, LocalDateTime createTime) {
        this.typeNo = typeNo;
        this.type = type;
        this.createTime = createTime;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
