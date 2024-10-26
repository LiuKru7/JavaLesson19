package opp.polymorphism.taxes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        Employee justas = new Employee("Justas", 30000);
        employeeList.add(justas);

        Employee algis = new Employee("Algis", 1000);
        employeeList.add(algis);

        Employee ramunas = new Employee("Ramunas", 2223);
        employeeList.add(ramunas);

        calculateTaxes(algis);
        TaxService.printSalaryAfterTaxes(algis);
        calculatePensionContributions(algis, 3);

        calculateTaxes(ramunas);
        TaxService.printSalaryAfterTaxes(ramunas);
        calculatePensionContributions(ramunas, 3);

        calculateTaxes(justas);
        TaxService.printSalaryAfterTaxes(justas);
        calculatePensionContributions(justas, 3);
        TaxService.calculateTotalTaxes(employeeList);
        TaxService.calculateTotalPensionContributions(employeeList, 3);
    }

    private static void calculatePensionContributions(Employee algis, double percentage) {
        var pensionContributions = TaxService.calculatePensionContribution(algis, percentage);
        System.out.printf("Employee %s pension contribution (%f) : %.2f  EUR ", algis.getName(), percentage, pensionContributions);
    }

    private static void calculateTaxes(Employee algis) {
        System.out.println("Employee " + algis.getName() + " taxes : " + TaxService.calculateTaxes(algis) + "EUR");
    }
}
