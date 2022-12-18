import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem implements Serializable {
    private final String filename;
    List<User> users = new ArrayList<>();

    RegistrationSystem(String filename) {

        this.filename = filename;
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
                users = (List<User>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public String getFileName() {
        return filename;
    }

    public User login(String nickname, String password) {
        for (User user : users) {
            if (user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean register(String nickname, String password) {

        for (User user : users) {
            if (user.getNickname().equals(nickname)) {
                return false;
            }
        }
        users.add(new User(nickname, password));
        return true;
    }

    public void saveData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(getFileName()))) {

            objectOutputStream.writeObject(users);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
