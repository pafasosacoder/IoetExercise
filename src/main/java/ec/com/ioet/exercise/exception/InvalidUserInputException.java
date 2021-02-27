package ec.com.ioet.exercise.exception;

public class InvalidUserInputException extends Exception {
    private String code;

    public InvalidUserInputException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public InvalidUserInputException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}