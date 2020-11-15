package assignment_aha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static String getName() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        while (true) {
            System.out.print("Input name: ");
            name = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z ]+$");
            if (p.matcher(name).find()) {
                break;
            } else {
                System.err.println("invalid name, please input again!");
            }
        }
        return name;
    }

    public static String getId() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        while (true) {
            System.out.print("Input ID: ");
            id = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z ]{2}[0-9]+$");
            if (p.matcher(id).find()) {
                break;
            } else {
                System.err.println("invalid id, please input again!");
            }
        }
        return id;
    }

    public static String getMail() {
        Scanner sc = new Scanner(System.in);
        String mail = "";
        while (true) {
            System.out.print("Input email: ");
            mail = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z]+(.[a-zA-Z]+)+$");
            if (p.matcher(mail).find()) {
                break;
            } else {
                System.err.println("invalid mail, please input again!");
            }
        }
        return mail;
    }

    public static String getMobi() {
        Scanner sc = new Scanner(System.in);
        String mobi = "";
        while (true) {
            System.out.print("Input mobiphone: ");
            mobi = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]{10}$");
            if (p.matcher(mobi).find()) {
                break;
            } else {
                System.err.println("invalid id, please input again!");
            }
        }
        return mobi;
    }

    public static String getPass() {
        Scanner sc = new Scanner(System.in);
        String password = "";
        while (true) {
            System.out.print("Input password: ");
            password = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-z0-9]{1,16}$");
            if (p.matcher(password).find()) {
                break;
            } else {
                System.err.println("invalid id, please input again!");
            }
        }
        return password;
    }

    public static String check() {
        Scanner sc = new Scanner(System.in);
        String check = "";
        while (true) {
            check = sc.nextLine();
            if (check == null || check.length() == 0) {
                System.err.println("invalid, please input again");
            } else {
                return check;
            }
        }

    }

    static void Menu() {
        System.out.println("=======================");
        System.out.println("1.Login system for Contestant ");
        System.out.println("2.Change profile information of Contestant ");
        System.out.println("3.Add a new problem to the Question Bank ");
        System.out.println("4.Update full information for a particular problem by Problem ID");
        System.out.println("5.A list of all available problems in the QB ");
        System.out.println("6.Generate a new Contest  ");
        System.out.println("7.Print information of a Contest by ContestID  ");
        System.out.println("8.Sort all problems by Category as ascending order ");
        System.out.println("9.Save, load, and export information ");
        System.out.println("10. Exit");
        System.out.println("=======================");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Menu();
        int choose;
        List<Contestant> list = new ArrayList<>();
        while (true) {
            System.out.print("Please enter choose(1-10): ");
            choose = Integer.parseInt(sc.nextLine());
            File file = new File("Contestant.dat");
            File file1 = new File("QBs.dat");
            switch (choose) {
                case 1:
                    String name = getName();
                    String id = getId();
                    String email = getMail();
                    String mobilephone = getMobi();
                    System.out.print("Input rank: ");
                    int rank = Integer.parseInt(sc.nextLine());
                    String password = getPass();
                    Contestant s = new Contestant(name, id, email, mobilephone, rank, password);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(s);
                    oos.close();
                    fos.close();

                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Contestant s1 = (Contestant) ois.readObject();
                    System.out.println("Data has been saved in Contestant.dat");
                    System.out.println(s1.toString());
                    break;
                case 2:
                    FileInputStream fis1 = new FileInputStream(file);
                    ObjectInputStream ois1 = new ObjectInputStream(fis1);
                    Contestant s2 = (Contestant) ois1.readObject();
                    System.out.println("Before changing profile information of Contestant");
                    System.out.println(s2.toString());
                    String name1 = getName();
                    String id1 = getId();
                    String email1 = getMail();
                    String mobilephone1 = getMobi();
                    System.out.print("INPUT RANK: ");
                    int rank1 = Integer.parseInt(sc.nextLine());
                    String password1 = getPass();
                    s2.setName(name1);
                    s2.setId(id1);
                    s2.setEmail(email1);
                    s2.setMobilephone(mobilephone1);
                    s2.setRank(rank1);
                    s2.setPassword(password1);
                    System.out.println("After changing profile information of Contestant");
                    System.out.println(s2.toString());
                    break;
                case 3:
                    System.out.print("Input ID problem: ");
                    String idPro = check();
                    System.out.print("Input date: ");
                    String date = check();
                    String namePro = getName();
                    System.out.print("Input description: ");
                    String des = check();
                    System.out.print("Input full description: ");
                    String fulldes = check();
                    System.out.print("Input mark: ");
                    double mark = Double.parseDouble(sc.nextLine());
                    System.out.print("Input category: ");
                    String cat = check();
                    System.out.print("Input author: ");
                    String author = check();
                    Problem p = new Problem(idPro, date, namePro, des, fulldes, mark, cat, author);
                    if (!file1.exists()) {
                        file1.createNewFile();
                    }
                    FileOutputStream fos1 = new FileOutputStream(file1);
                    ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
                    oos1.writeObject(p);
                    oos1.close();
                    fos1.close();

                    FileInputStream fis2 = new FileInputStream(file1);
                    ObjectInputStream ois2 = new ObjectInputStream(fis2);
                    Problem p1 = (Problem) ois2.readObject();
                    System.out.println("Data has been saved in Contestant.dat");
                    System.out.println(p1.toString());
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Invalid!");
                    break;
            }

        }
    }

}
