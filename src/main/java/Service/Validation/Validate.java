package Service.Validation;

import java.util.regex.Matcher;

import static Common.Common.*;

public class Validate {
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
    public static boolean validatePhone(String phoneStr){
        Matcher matcher = VALID_PHONE_REGEX.matcher(phoneStr);
        return matcher.matches();
    }
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
    public static boolean validateDate(String dateStr){
        Matcher matcher = VALID_DATE_REGEX.matcher(dateStr);
        return matcher.matches();
    }
    public static boolean validateNotNull(String str){
        str = str.trim();
        if (str == null || str.equals("")){
            return false;
        }
        return true;
    }
    public static String checkNull(String str){
        str = str.trim();
        if (str == null || str.equals("")){
            return "NULL";
        }
        return str;
    }
    public static boolean validateGender(String gender){
        String male = "nam" ;
        String female = "nữ";
        String other = "khác";
        gender = gender.trim();
        gender = gender.toLowerCase();
        if (male.equals(gender) == true || female.equals(gender) == true || other.equals(gender) == true){
            return true;
        }else {
            return false;
        }
    }
}
