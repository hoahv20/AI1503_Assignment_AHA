import java.io.ObjectStreamConstants;
import static java.lang.System.in;
import java.util.*;


public class Student {

    private String Name;
    private String ID; 
     private String Email; 
     private String Mobiphone; 
    private int Rank; 

    public Student() {
    }
    
    public Student(String Name,int Rank) {
        this.Name = Name;
        this.Rank = Rank;
    }
    
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public Student(String Name, String ID, String Email, String Mobiphone, int Rank) {
        this.Name = Name;
        this.ID = ID;
        this.Email = Email;
        this.Mobiphone = Mobiphone;
        this.Rank = Rank;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = "sdfsdf";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobiphone() {
        return Mobiphone;
    }

    public void setMobiphone(String Mobiphone) {
        this.Mobiphone = Mobiphone;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int Rank) {
        this.Rank = Rank;
    }
    
    public static int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        Name = sc.nextLine();
        Rank = checkInputInt();
    }
    
    
    public void display() {
        System.out.println(Name + " " + Rank);
    }
}