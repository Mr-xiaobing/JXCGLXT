package pojo;

import java.time.LocalDateTime;

/**
 * @author Xbin
 * @date 2020/7/2
 *
 */
public class UserMessage {
    private int userNo;
    private String userName;
    private String nickName;
    private String password;
    private String userPhone;
    private String userEmail;
    private LocalDateTime userDate;

    public UserMessage() {
        super();
    }

    public UserMessage(int userNo, String userName, String nickName, String password, String userPhone, String userEmail, LocalDateTime userDate) {
        this.userNo = userNo;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userDate = userDate;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getUserDate() {
        return userDate;
    }

    public void setUserDate(LocalDateTime userDate) {
        this.userDate = userDate;
    }
}
