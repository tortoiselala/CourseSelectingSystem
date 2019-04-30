package cn.tortoise.utils;

import cn.tortoise.entity.User;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;

public class UserUtil {
    public static void userParmCheck(User user) throws IllegalArgumentCheckedException {
        if(user  == null || !user.isStudent()
                || user.getUsername() == null
                || user.getPassword() == null
                || user.getUsername().length() == 0
                || user.getPassword().length() == 0){
            throw new IllegalArgumentCheckedException(user.toString());
        }
    }
}
