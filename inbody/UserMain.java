package inbody;
import java.util.*;

public class UserMain{
    public static List<SearchUser> searchUsers = new ArrayList<>();

    public static boolean checkUserId(List<User> users, String id) {
        boolean bIsSame = false;
        for (int i = 0; i < users.size(); i++) {
            User User = users.get(i);
            if (id.equals(User.getId())) {
                bIsSame = true;
                break;
            }
        }
        return bIsSame;
    }
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("./user.dat");
        List<User> users = userDao.getUsers();

        while(true){
            int menuId = userUI.menu();
            
            // 0.프로그램 종료
            if(menuId == 0){
                System.out.println("종료합니다.");
                userDao.saveUser(users);
                break;
    
            // 1.회원 입력
            } else if(menuId == 1){
                User user = userUI.regUser();
                // 회원번호 같은지 확인후 저장
                if (checkUserId(users, user.getId()) == true) {
                    System.out.println("Error: 등록된 회원번호가 있습니다. 다른 회원번호를 등록하세요.");
                } else {
                    users.add(user);
                    System.out.println("등록되었습니다.");
                }

            // 2.전체 회원목록 보기
            } else if(menuId == 2) {
                userUI.printUserList(users);

            // 3.회원 이름 또는 회원번호로 검색
            } else if (menuId == 3) {
                String nameOrId = userUI.InputNameOrId();
                int findIndex = -1;
                for (int i = 0; i < users.size(); i++) {
                    User u = users.get(i);

                    if (u.getName().equals(nameOrId) || u.getId().equals(nameOrId)) {
                        SearchUser searchUser = new SearchUser(u.getName(), u.getId(), u.getSex(), u.getDate());
                        searchUsers.add(searchUser);
                        findIndex = i;
                        break;
                    }
                }
                System.out.println("회원목록");
                userUI.PrintSearchUserList(searchUsers);

                if (findIndex == -1){ // 회원 목록에서 못찾음
                    System.out.println("등록된 회원이 없습니다.");
                }

            // 5.회원 삭제
            } else if(menuId == 5){
                String nameOrId = userUI.InputNameOrId();
                int findIndex = -1;
                for(int i=0;i<users.size();i++){
                    User u = users.get(i);
                    if(u.getName().equals(nameOrId) || u.getId().equals(nameOrId)){
                        findIndex = i;
                        break;
                    }
                }

                if(findIndex != -1){
                    users.remove(findIndex);
                    System.out.println("회원정보 삭제하였습니다.");
                }
                else{
                    System.out.println("삭제할 회원 정보가 없습니다.");
                }
            }
        }
    }
}