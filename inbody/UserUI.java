package inbody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class UserUI {
    private BufferedReader br;

    public UserUI(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu(){
        System.out.println("1. 회원등록");
        System.out.println("2. 전체 회원목록 보기");
        System.out.println("3. 이름 또는 회원번호로 검색");
        System.out.println("5. 회원정보 삭제하기");
        System.out.println("0. 종료");
        int menuId = -1;
        try {
            String line = br.readLine();
            menuId = Integer.parseInt(line);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return menuId;
    }

    public String InputNameOrId(){
        System.out.println("회원의 이름 또는 회원번호를 입력하세요.");
        String input = "";
        try{
            input = br.readLine();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return input;
    }

    public User regUser(){
        try{
            System.out.println("성명을 입력하세요.");
            String name = br.readLine();
            System.out.println("회원번호를 입력하세요.");
            String id = br.readLine();
            System.out.println("성별을 입력하세요.");
            String sex = br.readLine();
            System.out.println("검사일시를 입력하세요.");
            String date = br.readLine();

            User user = new User(name, id, sex, date);
            return user;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void PrintSearchUserList(List<SearchUser> searchUsers) {
        System.out.println("이름            회원번호             성별              검사일시 ");
        System.out.println("============================================================");
        for(int i=0; i<searchUsers.size();i++) {
            SearchUser searchuser = searchUsers.get(i);
            System.out.print(searchuser.getName());
            System.out.print("            ");
            System.out.print(searchuser.getId());
            System.out.print("             ");
            System.out.print(searchuser.getSex());
            System.out.print("             ");
            System.out.println(searchuser.getDate());
        }
    }

    public void printUserList(List<User> users){
        System.out.println("이름            회원번호             성별              검사일시 ");
        System.out.println("============================================================");
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            System.out.print(user.getName());
            System.out.print("            ");
            System.out.print(user.getId());
            System.out.print("             ");
            System.out.print(user.getSex());
            System.out.print("             ");
            System.out.println(user.getDate());
        }
        System.out.println("------------------------------------------------------------");
    }
}