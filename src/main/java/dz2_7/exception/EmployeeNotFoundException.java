package dz2_7.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String s) {
        super(s);
    }
}
