package inbody;

import java.io.Serializable;

/*
 * History 기능. 검색한 회원의 이름 또는 회원번호 목록
 */

public class SearchUser implements Serializable {
    private String name;
    private String id;
    private String sex;
    private String date;

    public SearchUser(String name, String id, String sex, String date){
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
