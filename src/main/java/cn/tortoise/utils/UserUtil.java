package cn.tortoise.utils;

import cn.tortoise.model.entity.User;

public class UserUtil {
    public static void userParmCheck(User user) {
        if(user  == null
                || user.getUsername() == null
                || user.getPassword() == null
                || user.getUsername().length() == 0
                || user.getPassword().length() == 0){
            throw new IllegalArgumentException(user.toString());
        }
    }
}
