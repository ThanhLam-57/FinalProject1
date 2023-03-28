package Service.Validation;

import java.util.regex.Matcher;

import static Common.Common.*;

public class Validate {
    /**
    *@author: NTLAM
    *@since:
    *@description: Phương thức kiểm tra email
    *@return: true nếu email hợp lệ
    */
    public static boolean validateEmail(String emailStr) {
        emailStr = emailStr.trim();
        if (emailStr.equals("") == true){
            return true;
        }
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    /**
    *@author:NTLAM
    *@since:
    *@description: Phương thức kiểm tra số điện thoại
    *@return: true nếu số điện thoại hợp lệ
    */
    public static boolean validatePhone(String phoneStr){
        phoneStr = phoneStr.trim();
        if (phoneStr.equals("")== true){
            return true;
        }
        Matcher matcher = VALID_PHONE_REGEX.matcher(phoneStr);
        return matcher.matches();
    }

    /**
    *@author: NTLAM
    *@since:
    *@description: phương thức kiểm tra số
    *@return: true nếu là số
    */
    public static boolean isNumeric(String string) {
        int intValue;
        string = string.trim();

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
    *@author:NTLAM
    *@since:
    *@description: phương thức kiểm tra định dạng ngày YYYY-MM-DD
    *@return: true nếu ngày tháng đúng đingj dạng
    */
    public static boolean validateDate(String dateStr){
        Matcher matcher = VALID_DATE_REGEX.matcher(dateStr);
        return matcher.matches();
    }

    /**
    *@author:NTLAM
    *@since:
    *@description: phương thức kiểm tra chuỗi không rỗng
    *@return: true nếu chuỗi không rỗng
    */
    public static boolean validateNotNull(String str){
        str = str.trim();
        if (str == null || str.equals("")){
            return false;
        }
        return true;
    }

    /**
    *@author:
    *@since:
    *@description:
    *@return:
    */
    public static String checkNull(String str){
        str = str.trim();
        if (str == null || str.equals("")){
            return "NULL";
        }
        return str;
    }

    /**
    *@author:NTLAM
    *@since:
    *@description: phương thức kiểm tra định dạng giới tính
    *@return: true nếu giới tính đúng định dạng
    */
    public static boolean validateGender(String gender){
        String male = "nam" ;
        String female = "nữ";
        String other = "khác";
        gender = gender.trim();
        gender = gender.toLowerCase();
        if (male.equals(gender) == true || female.equals(gender) == true || other.equals(gender) == true){
            return true;
        } else if (gender.equals("") == true) {
            return true;
        } else {
            return false;
        }
    }
}
