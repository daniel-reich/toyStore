package toyStore.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee_info")
public class User {

    public static enum EmployeePosition {EMPLOYEE, MANAGER, OWNER};
    public static enum EmployeeDepartment {KIDS_TOYS, ELECTRONICS, ALL};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    @NotNull
    private String employeeName;

    @NotNull
    private String empoyeePassword;

    @NotNull
    private String employeeEmail;

    @NotNull
    private EmployeePosition employeePosition;

    @NotNull
    private EmployeeDepartment employeeDepartment;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmpoyeePassword() {
        return empoyeePassword;
    }

    public void setEmpoyeePassword(String empoyeePassword) {
        this.empoyeePassword = empoyeePassword;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public EmployeeDepartment getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(EmployeeDepartment employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}