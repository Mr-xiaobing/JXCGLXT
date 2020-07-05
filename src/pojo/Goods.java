package pojo;

/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class Goods {

    private  int goodsNo;

    private  String goodsName;

    private  Integer typeNo;

    private  int providerNo;

    private  String specification;

    private  String gRemark;

    private  String mainImage;


    public Goods() {
        super();
    }

    public Goods(int goodsNo, String goodsName, Integer typeNo, int providerNo, String specification, String gRemark, String mainImage) {
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
        this.typeNo = typeNo;
        this.providerNo = providerNo;
        this.specification = specification;
        this.gRemark = gRemark;
        this.mainImage = mainImage;
    }

    public int getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(int goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Integer typeNo) {
        this.typeNo = typeNo;
    }

    public String getgRemark() {
        return gRemark;
    }

    public void setgRemark(String gRemark) {
        this.gRemark = gRemark;
    }

    public int getProviderNo() {
        return providerNo;
    }

    public void setProviderNo(int providerNo) {
        this.providerNo = providerNo;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getGRemark() {
        return gRemark;
    }

    public void setGRemark(String gRemark) {
        this.gRemark = gRemark;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
}
