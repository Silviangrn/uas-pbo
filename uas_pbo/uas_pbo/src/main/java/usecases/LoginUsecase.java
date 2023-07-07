package usecases;

import com.zaxxer.hikari.HikariDataSource;

import entities.UserEntity;
import models.LoginModel;
import utils.DBConnectionUtil;

public class LoginUsecase {
    private HikariDataSource dataSource;

    private LoginModel loginModel;

    public LoginUsecase () {
        dataSource = DBConnectionUtil.geDataSource();
        loginModel = new LoginModel(dataSource);
    }

    public String LoginValidate(String userid, String password) {
        //validasi, Inputan tidak boleh kosong
        if (userid.equals("") || password.equals("")) {
            return "-- Userid and Password cannot be empty!! --";
        }

        UserEntity user = new UserEntity();
        user.setUserid(userid);
        user.setPassword(password);

        //Validasi, User ada di database
        if (!loginModel.CheckUser(user.getUserid())) {
            return "-- Userid is not exists, please try again -- ";
        }
        
        //Validasi, User ada di database
        if (!loginModel.CheckPass(user)) {
            return "-- Userid and Password are not exists, please try again -- ";
        }
        
        return "";
    }
}
