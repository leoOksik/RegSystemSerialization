import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String numStr = "";
        RegistrationSystem registrationSystem = new RegistrationSystem("users.out");

        //registrationSystem.users.forEach(System.out::println);

        System.out.println("1.Authorization" + "\n2.Registration" + "\n3.Exit");
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        while (!(Objects.equals(numStr, "3"))) {

            numStr = sc.next();

            while (!numStr.matches("(1)|(2)|(3)")) {
                System.out.println("Wrong number");
                numStr = sc.next();
            }

            switch (numStr) {
                case "1" -> {
                    System.out.println("Enter the login");
                    String name = sc.next();
                    System.out.println("Enter the password");
                    String password = sc2.nextLine();
                    String log = String.valueOf(registrationSystem.login(name, password));
                    System.out.println(log.equals("null") ? "Incorrect login or password" : "Authorization is successful");
                }
                case "2" -> {
                    System.out.println("Enter the login");
                    String name2 = sc.next();
                    System.out.println("Enter the password");
                    String password2 = sc.next();
                    boolean rez = registrationSystem.register(name2, password2);
                    System.out.println(!rez ? "\nSuch user already exist" : "\nRegistration is successful");

                }
                default -> {
                    numStr = "3";
                }
            }
        }
        registrationSystem.saveData();
    }
}
