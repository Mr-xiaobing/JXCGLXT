package pojo;

/**
* @author Xbin
* @date 2020/7/2
*
*/


public class Client {

    private int clientNo;

    private String client;

    private String cAddress;

    private String cEmail;

    private String cPhone;

    public Client() {
        super();
    }

    public Client(int clientNo, String client, String cAddress, String cEmail, String cPhone) {
        this.clientNo = clientNo;
        this.client = client;
        this.cAddress = cAddress;
        this.cEmail = cEmail;
        this.cPhone = cPhone;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }
}
