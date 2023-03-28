package Service.Validation;

public class FormatValidate {

    /**
    *@author:NTLAM
    *@since:
    *@description:Phương thức format số
    *@return:true nếu là số
    */
    public static Integer formatInteger(String str){
        if(str == null || str.equals("")){
            return 0;
        }else {
            return Integer.parseInt(str);
        }
    }
}
