package assignment_aha;

import java.io.Serializable;

public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idPro;
    private String date;
    private String namePro;
    private String description;
    private String fullDescription;
    private double mark;
    private String category;
    private String author;

    public Problem() {
        idPro = "NoId";
        date = "NoDate";
        namePro = "NoName";
        description = "NoDescription";
        fullDescription = "NoFullDescription";
        author = "author";
    }

    public Problem(String id, String date, String name, String description, String fullDescription, String author) {
        this.idPro = id;
        this.date = date;
        this.namePro = name;
        this.description = description;
        this.fullDescription = fullDescription;
        this.author = author;
    }

    public Problem(String idPro, String date, String namePro, String description, String fullDescription, double mark, String category, String author) {
        this.idPro = idPro;
        this.date = date;
        this.namePro = namePro;
        this.description = description;
        this.fullDescription = fullDescription;
        this.mark = mark;
        this.category = category;
        this.author = author;
    }

    
    public String getIdPro() {
        return idPro;
    }

    public void setIdPro(String idPro) {
        this.idPro = idPro;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNamePro() {
        return namePro;
    }

    public void setNamePro(String namePro) {
        this.namePro = namePro;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return idPro + "\t" + date + "\t" + namePro + "\t" + description + "\t" + fullDescription + "\t" + mark + "\t" + author;
    }
}
