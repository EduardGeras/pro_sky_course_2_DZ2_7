package dz2_7.exception;

public class EmployeeAlreadyAddedException  extends RuntimeException {
    public EmployeeAlreadyAddedException(String s) {
        super(s);
    }
}
