package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidateTest {

    @org.junit.Test
    public void validateEmail() {
        String email = "lamnguyen.tln22@gmail.com";
        boolean expected = true;
        boolean result = Service.Validation.Validate.validateEmail(email);
        assertTrue(expected == result);
    }

    @org.junit.Test
    public void validatePhone() {
        String phone = "0123456789";
        boolean expected = true;
        boolean result = Service.Validation.Validate.validatePhone(phone);
        assertTrue(expected == result);
    }

    @org.junit.Test
    public void isNumeric() {
        String number = "123";
        boolean expected = true;
        boolean result = Service.Validation.Validate.isNumeric(number);
        assertTrue(expected == result);
    }

    @org.junit.Test
    public void validateDate() {
        String date = "2020-12-12";
        boolean expected = true;
        boolean result = Service.Validation.Validate.validateDate(date);
        assertTrue(expected == result);
    }

    @org.junit.Test
    public void validateNotNull() {
    }

    @org.junit.Test
    public void checkNull() {
    }

    @org.junit.Test
    public void validateGender() {
        String name = "Nam";
        boolean expected = true;
        boolean result = Service.Validation.Validate.validateGender(name);
        assertTrue(expected == result);
    }

}