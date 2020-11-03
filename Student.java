import java.util.Scanner;

public class Student {
    String Name;
    String Id;
    String Email;
    String PhoneNumber;
    String Rank;
    
    
    Student() {
        
    }

    public Student(String Name, String Id, String Email, String Rank) {
        this.Name = Name;
        this.Id = Id;
        this.Email = Email;
        this.Rank = Rank;
    }

    public String getName() {
        return Name;
    }

    public String getId() {
        return Id;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getRank() {
        return Rank;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }
    
    
    
    public void input() {
           Scanner sc = new Scanner(System.in);
           Name = sc.nextLine();
           Id = sc.nextLine();
           Email = sc.nextLine();
           PhoneNumber = sc.nextLine();
           Rank = sc.nextLine();
    }
    
    public void display() {
        System.out.println(Name + " " + Id + " " + Email + " " + PhoneNumber + " " + Rank);
    }
    
}