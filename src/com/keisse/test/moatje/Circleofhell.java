package com.keisse.test.moatje;

import com.keisse.test.moatje.models.Manager;
import com.keisse.test.moatje.models.Person;
import com.keisse.test.moatje.models.Student;
import com.keisse.test.moatje.models.Teacher;

import java.util.*;

public class Circleofhell {
    static final String WHAT_MSG = "What is message?";

    public static void main(String[] args) {
        new Circleofhell().torment();
    }

    String[] firstnames = {"Ali", "Abdul", "Muhammad", "Ali'baba", "Sultan", "Ja'far"};
    String[] names = {" ibn al Walid", "ibn Muhammad", "Kech", "Arabiri", "ibn al Massad", "ibn Mustafa"};
    String[] usernames = {"crazy_girl420", "mamma_mia69", "ayy_papi", "AllahTheGreat", "muslimBoy", "Kaaba"};
    List<Person> freshAccs = new ArrayList<>();

    void createAccounts() {
        Random rand = new Random();
        Set set = Set.of(usernames);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            int rtype = rand.nextInt(3);
            Person p = null;
            switch (rtype) {
                case 0:
                    p = new Manager();
                    break;
                case 1:
                    p = new Teacher();
                    break;
                case 2:
                    p = new Student();
                    break;
            }

            String pw = "";
            for (int j = 0; j < 4; j++) {
                pw += rand.nextInt(9);
            }

            p.createAccount(iterator.next(), pw);

            p.create(names[rand.nextInt(5)], firstnames[rand.nextInt(5)]);
            freshAccs.add(p);
        }
        for (Person per : freshAccs)
            System.out.println(per);
    }

    //run method, but it's torture to do so :'(
    public void torment() {
        boolean loggedIn = false;
        Person activeUser = null;
        createAccounts();

        try (Scanner scanner = new Scanner(System.in)) {
            while (!loggedIn) {
                System.out.println("Welcome, please login to the system");
                System.out.println("provide username:");
                String username = scanner.nextLine();
                System.out.println("provide password:");
                String password = scanner.nextLine();

                for (Person p : freshAccs) {

                    if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                        loggedIn = true;
                        activeUser = p;
                        System.out.println("got it!");
                        break;
                    }
                }
                if (!loggedIn)
                    System.out.println("not able to find user, try again..");
            }

            System.out.println("Welcome, " + activeUser.getUsername());
            String classname = activeUser.getClass().getName();//has class-structure, we only need last of it: com.keisse.test.moatje.models.Teacher
            classname = classname.substring(classname.lastIndexOf('.') + 1); //Teacher
            switch (classname) {
                case "Manager":
                    managerMenuLoop(scanner, (Manager) activeUser);
                    break;
                case "Student":
                    studentMenuLoop(scanner, (Student) activeUser);
                    break;
                case "Teacher":
                    teacherMenuLoop(scanner, (Teacher) activeUser);
                    break;
            }
        }
        System.out.println("End of the run.");
    }

    private void managerMenuLoop(Scanner scanner, Manager p) {
        while (true) {
            System.out.println("1. Ban user");
            System.out.println("2. LOGOUT");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("provide username to ban:");
                    p.banUser(scanner.nextLine(), freshAccs);
                    break;
                case 2:
                    return;
            }
        }
    }

    private void studentMenuLoop(Scanner scanner, Student p) {
        while (true) {
            System.out.println("1. send Message");
            System.out.println("2. LOGOUT");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println(WHAT_MSG);
                    String msg = scanner.nextLine();
                    p.sendMessage(msg);
                    break;
                case 2:
                    return;
            }
        }
    }

    private void teacherMenuLoop(Scanner scanner, Teacher p) {
        while (true) {
            System.out.println("1. send Message to student");
            System.out.println("2. send Message to all students");
            System.out.println("3. LOGOUT");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("What student do you want to adress?");
                    String target = scanner.nextLine();
                    boolean sent = false;
                    for (Person student : freshAccs) {
                        if (student.getUsername().equals(target)) {
                            System.out.println(WHAT_MSG);
                            String msg = scanner.nextLine();
                            p.sendMessageToStudent(msg, (Student) student);
                            sent = true;
                        }
                    }
                    if (!sent)
                        System.out.println("Did not find a student with this name..");
                    break;
                case 2:
                    System.out.println(WHAT_MSG);
                    String msg = scanner.nextLine();
                    p.sendMessageToAll(msg);
                    break;
                case 3:
                    return;
            }
        }
    }
}
