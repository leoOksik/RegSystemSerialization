import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class User implements Serializable {

    private String nickname;
    private String password;
    private Date registrationDate;

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
        registrationDate = new Date();
        DateFormat.getDateInstance(DateFormat.SHORT).format(registrationDate);
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname: '" + nickname + '\'' +
                ", password: '" + password + '\'' +
                ", registrationDate: " +  DateFormat.getDateInstance(DateFormat.SHORT).format(registrationDate)+
                '}';
    }
}
