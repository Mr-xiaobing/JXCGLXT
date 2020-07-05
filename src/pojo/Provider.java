package pojo;


/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class Provider {
    private int providerNo;
    private String provider;
    private String pAddress;
    private String pLinkman;
    private String pEmail;
    private String pPhone;

    public Provider() {
        super();
    }

    public Provider(int providerNo, String provider, String pAddress, String pLinkman, String pEmail, String pPhone) {
        this.providerNo = providerNo;
        this.provider = provider;
        this.pAddress = pAddress;
        this.pLinkman = pLinkman;
        this.pEmail = pEmail;
        this.pPhone = pPhone;
    }

    public int getProviderNo() {
        return providerNo;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public void setProviderNo(int providerNo) {
        this.providerNo = providerNo;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPLinkman() {
        return pLinkman;
    }

    public void setPLinkman(String pLinkman) {
        this.pLinkman = pLinkman;
    }

    public String getPEmail() {
        return pEmail;
    }

    public void setPEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getPPhone() {
        return pPhone;
    }

    public void setPPhone(String pPhone) {
        this.pPhone = pPhone;
    }
}
