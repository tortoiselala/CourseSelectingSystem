package cn.tortoise.utils;

import cn.tortoise.constant.CommonConstant;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import org.springframework.util.DigestUtils;

public class CourseUtil {
    private static final int DAY_NUM = 7;
    private static final int WEEK_NUM = 20;
    private static final int CLASS_TIME_NUM = 12;
    private static final int ALLOW_GRADE_NUM = 4;

    public static String decodeDays(int days){
        return decode(days, DAY_NUM);
    }

    public static String decodeWeeks(int weeks){
        return decode(weeks, WEEK_NUM);
    }

    public static String decodeClassTime(int classTime){
        return decode(classTime, CLASS_TIME_NUM);
    }

    public static String decodeAllowGrade(int allowGrade){
        return decode(allowGrade, ALLOW_GRADE_NUM);
    }

    private static String decode(int days, int dayNum) {
        int mark = 1;
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(int i = 0; i < dayNum; ++i){
            if((mark & (days >>> i)) == mark){
                if(!first){
                    sb.append(',');
                }else{
                    first = false;
                }
                sb.append(i + 1);
            }
        }
        return sb.length() == 0 ? "none" : sb.toString();
    }

    public static String getMd5(long courseId){
        return DigestUtils.md5DigestAsHex((courseId + "/" + CommonConstant.MD5_SALT).getBytes());
    }

    public static boolean md5Check(long courseId, String expected){
       return expected != null && getMd5(courseId).equals(expected);
    }

    public static boolean scoreCheck(int score){
        return scoreCheck(score, 0, 100);
    }

    public static boolean scoreCheck(int score, int min, int max){
        if(score < min || score > max){
            return false;
        }
        return true;
    }
}
