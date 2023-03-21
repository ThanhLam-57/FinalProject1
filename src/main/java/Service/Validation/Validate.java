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

        System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    public static boolean validateDate(String dateStr){
        Matcher matcher = VALID_DATE_REGEX.matcher(dateStr);
        return matcher.matches();
    }
    public static boolean validateNotNull(String str){
        Matcher matcher = VALID_NOT_EMPTY_REGEX.matcher(str);
        return matcher.matches();
    }
}
