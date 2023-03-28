package Service.Validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetTaxTest {

    @Test
    public void getTax() {
        double salary = 10000000;
        double expected = 500000;
        double result = Service.Validation.GetTax.getTax(salary);

    }

    @Test
    public void getTaxSalary() {
        long salaryToTax = 10000000;
        long expected = 500000;
        long result = (long) GetTax.getTaxSalary(salaryToTax);
    }
}