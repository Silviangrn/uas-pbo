package usecases;

import com.zaxxer.hikari.HikariDataSource;

import entities.UserEntity;
import models.UserModel;
import utils.DBConnectionUtil;

public class UserUsecase {
    private HikariDataSource dataSource;

    private UserModel userModel;

    public UserUsecase() {
        dataSource = DBConnectionUtil.geDataSource();
        userModel = new UserModel(dataSource);
    }

    public void getUserList() {
        UserEntity[] userList = userModel.FindUser();
        for (UserEntity user : userList) {
            System.out.println("- " + user.getUserid());
        }
    }

    public void addUser(String userid, String pass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(userid);
        userData.setPassword(pass);
        userModel.CreateUser(userData);
        System.out.println("Create User - Succeed!");
    }

    public void changePassUser(String newUserid, String newPass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(newUserid);
        userData.setPassword(newPass);
        userModel.ChangePass(userData);
        System.out.println("Change Password - Succeed!");
    }
}
    

