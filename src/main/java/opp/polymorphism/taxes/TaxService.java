package opp.polymorphism.taxes;

import java.util.List;

public class TaxService {
    private static final double GPM = 20;
    private static final double MAX_GPM = 32;
    private static final double PSD = 6.98;
    private static final double VSD = 12.52;
    private static final double VDU = (1902.7 * 60 / 12);
    private static final double MMA = 924;
    private static final double NPD_MID_CONST = 2167;
    private static final double NPD_MAX_CONST = 2864.22;


    public static double calculateTaxes(Employee employee) {

        double gpmSum = -1;
        if (MMA >= employee.getSalary()) {
            double sum = employee.getSalary() - 747;
            gpmSum = sum * (GPM / 100);
        } else if (NPD_MID_CONST > employee.getSalary()) {
            double npd = 747 - 0.5 * (employee.getSalary() - MMA);
            gpmSum = (employee.getSalary() - npd) * (GPM / 100);
        } else if (NPD_MAX_CONST > employee.getSalary()) {
            double npd = 400 - 0.18 * (employee.getSalary() - 642);
            gpmSum = (employee.getSalary() - npd) * (GPM / 100);
        }

        if (VDU >= employee.getSalary()) {
            if (gpmSum == -1) {
                gpmSum = employee.getSalary() * (GPM / 100);
            }
            double psdSum = employee.getSalary() * (PSD / 100);
            double vsdSum = employee.getSalary() * (VSD / 100);
            return gpmSum + psdSum + vsdSum;
        }

        double salaryOverVdu = employee.getSalary() - VDU;
        if (gpmSum == -1) {
            gpmSum = VDU * (GPM / 100) + salaryOverVdu * (MAX_GPM / 100);
        }
        double psdSum = employee.getSalary() * (PSD / 100);
        double vsdSum = employee.getSalary() * (VSD / 100);
        return gpmSum + psdSum + vsdSum;
    }

    public static void calculateTotalTaxes(List<Employee> employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += calculateTaxes(employee);
        }
        System.out.printf("Total taxes: %.2f EUR%n", sum);
    }

    public static double calculatePensionContribution(Employee employee, double percentage) {
        return employee.getSalary() * (percentage / 100);
    }

    public static void calculateTotalPensionContributions(List<Employee> employees, double percentage) {
        double pensionSum = 0;
        for (Employee employee : employees) {
            pensionSum += calculatePensionContribution(employee, percentage);
        }
        System.out.println("Total pension contribution (" + percentage + "%): " + pensionSum + "EUR");
    }

    public static void printSalaryAfterTaxes(Employee employee) {

        System.out.printf("Salary after taxes: %.2f EUR %n", (employee.getSalary() - calculateTaxes(employee)));
    }
}
