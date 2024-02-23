package inbody;
import java.io.*;

public class User implements Serializable {
    private String name;
    private String id;
    private String sex;
    private String date;

    public User(String name, String id, String sex, String date){
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.date = date;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getSex() {
        return sex;
    }
    public String getDate() {
        return date;
    }
    public String toString() {
        return getName() + getId() + getSex() + getDate();
    }
}
