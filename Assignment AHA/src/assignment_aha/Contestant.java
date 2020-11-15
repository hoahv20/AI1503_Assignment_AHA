package assignment_aha;

import java.io.Serializable;

class Contestant implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String id;
    private String email;
    private String mobilephone;
    private int rank;
    private String password;

    public Contestant() {
        name = "NoName";
        id = "NoID";
        email = "Noemail";
        mobilephone = "NoMobilephone";
        rank = 0;

    }

    public Contestant(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Contestant(String name, String id, String email, String mobilephone, int rank, String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.mobilephone = mobilephone;
        this.rank = rank;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return  "Name: "+name + "\t"+"ID: " + id + "\t" +"EMAIL: "+ email + "\t"+"MOBILEPHONE: " + mobilephone + "\t Rank:" + rank+"\t PASSSWORD: "+password;
    }

    
}
