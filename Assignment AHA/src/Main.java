package javaapplication50;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Do you want to choose Y or N? ");
            String result = sc.nextLine();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N? ");
            System.out.println("Enter again: ");
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

    public void showList(ArrayList<Contestant> ls) {
        for (Contestant o : ls) {
            System.out.println(o);
        }
    }

    public void changeCon(ArrayList<Contestant> lss, String id) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < lss.size(); i++) {
            if (lss.get(i).getId().equalsIgnoreCase(id)) {
                String name1 = getName();
                System.out.println("The old name: " + lss.get(i).getName());
                String id1 = getId();
                System.out.println("The old ID: " + lss.get(i).getId());
                String email1 = getMail();
                System.out.println("The old email: " + lss.get(i).getEmail());
                String mobilephone1 = getMobi();
                System.out.println("The old mobilephone: " + lss.get(i).getMobilephone());
                System.out.print("INPUT RANK: ");
                int rank1 = Integer.parseInt(sc.nextLine());
                System.out.println("The old rank: " + lss.get(i).getRank());
                String password1 = getPass();
                System.out.println("The old password: " + lss.get(i).getPassword());
                lss.get(i).setName(name1);
                lss.get(i).setId(id1);
                lss.get(i).setEmail(email1);
                lss.get(i).setMobilephone(mobilephone1);
                lss.get(i).setRank(rank1);
                lss.get(i).setPassword(password1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Contestant> ls = new ArrayList<>();
        ls.add(new Contestant("Nguyen Van A", "HA10000", "hello12@gmail.com", "0987654321", 1, "123456"));
        ls.add(new Contestant("Nguyen Van B", "HE13623", "hello123@gmail.com", "0887654321", 2, "01234567"));
        ls.add(new Contestant("Nguyen Van V", "HS15235", "hello15@gmail.com", "0997654321", 5, "8123456"));
        ls.add(new Contestant("Nguyen Van D", "HF14643", "hello23@gmail.com", "0934654321", 3, "9123456"));
        ls.add(new Contestant("Nguyen Van R", "HG15502", "hello152@gmail.com", "0687654321", 4, "32123456"));
        ls.add(new Contestant("Nguyen Van K ", "He15502", "hello999@gmail.com", "0687654321", 4, "7723456"));
        ls.add(new Contestant("Nguyen Van M", "HS14773", "hello777@gmail.com", "0637654321", 4, "41243456"));
        ls.add(new Contestant("Nguyen Van E", "HQ15121", "hello555@gmail.com", "0827654321", 4, "5223456"));
        ls.add(new Contestant("Nguyen Van W", "HA12101", "hello444@gmail.com", "0993765432", 4, "61223456"));
        ls.add(new Contestant("Nguyen Van P", "HE11111", "hello323@gmail.com", "0667654321", 4, "9823456"));
        try {
            FileWriter fw = new FileWriter("Contestant.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Contestant o : ls) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }

        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        Menu();
        int choose;
        while (true) {
            System.out.print("Please enter choose(1-10): ");
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {

                case 1:
                    String id = getId();
                    String password = getPass();
                    System.err.println("Login successfull.");
                    break;
                case 2:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("List of contestants.");
                    main.showList(ls);
                    System.out.println("Do you still want change profile information of Contestant?");
                    if (checkInputYN()) {
                        System.out.print("Enter the student ID to change: ");
                        String id1 = sc1.nextLine();
                        main.changeCon(ls, id1);
                        try {
                            FileWriter fw = new FileWriter("Contestant.dat");
                            BufferedWriter bw = new BufferedWriter(fw);
                            for (Contestant o : ls) {
                                bw.write(o.toString());
                                bw.newLine();
                            }
                            bw.close();
                            fw.close();
                        } catch (Exception e) {
                        }
                        System.err.println("Successful change!!!");
                    }

                    break;
                case 3:
                    System.out.print("Input ID: ");
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
                    try {
                        FileWriter fw = new FileWriter("QBs.dat");
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(p.toString());
                        bw.close();
                        fw.close();
                    } catch (Exception e) {
                    }

                    System.out.println("Data has been saved in Contestant.dat");

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
