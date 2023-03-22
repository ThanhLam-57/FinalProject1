package Service.Validation;

public class FormatValidate {
    public static Integer formatInteger(String str){
        if(str == null || str.equals("")){
            return 0;
        }else {
            return Integer.parseInt(str);
        }
    }
}
