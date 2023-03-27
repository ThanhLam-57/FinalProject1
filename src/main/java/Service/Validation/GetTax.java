package Service.Validation;

public class GetTax {
    public static double getTax(double salary) {

        double salaryToTax = salary - 11000000;

        return getTaxSalary(salaryToTax);
    }

    /**
     * Phương thức tính thuế thu nhập cá nhân
     *
     * @param salaryToTax Tiền thuế
     * @return tiền
     */
    private static double getTaxSalary(double salaryToTax) {
        if (salaryToTax < 0) {
            return 0;
        } else if (salaryToTax <= 5000000 && salaryToTax > 0) {
            return salaryToTax * 0.05;
        } else if ( salaryToTax <= 10000000) {
            return getTaxSalary(5000000) + (salaryToTax - 5000000) * 0.1;
        } else if (salaryToTax <= 18000000) {
            return getTaxSalary(10000000)+ (salaryToTax -10000000)* 0.15;
        } else if ( salaryToTax <= 32000000) {
            return getTaxSalary(18000000) +(salaryToTax -18000000)* 0.2;
        } else if (salaryToTax <= 52000000) {

            return getTaxSalary(32000000)+( salaryToTax -32000000) * 0.25;
        } else if ( salaryToTax <= 80000000) {
            return getTaxSalary(52000000)+ (salaryToTax -52000000) * 0.3;
        } else {
            return getTaxSalary(80000000)+ (salaryToTax -80000000) * 0.35;
        }
    }
}
