package personpackage;

import carpackage.BMW;
import carpackage.BMWextended;

public class Employee extends Person {
    private long insuranceNumber;
    private BMW bmw;

    public Employee(int age, int gender, long insuranceNumber) {
        super(age, gender);
        this.insuranceNumber = insuranceNumber;
        this.bmw = new BMWextended(23, true, 1_000_000);
    }

    public static void main(String[] args) {
        Employee employee = new Employee(36, 1, 123123123123L);
        System.out.println(employee.bmw.getPriceTag());
        System.out.println(Employee.getHello());
        System.out.println(yolo());
        //System.out.println(employee.bmw.printStringProtectedAccess());
    }

    public static String yolo() {
        return "yolo";
    }

    public long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}
