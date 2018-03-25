package by.tc.epam.dao.exception;

public class ParsingDAOException extends Exception{
    public ParsingDAOException() {
    }

    public ParsingDAOException(String message) {
        super(message);
    }

    public ParsingDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParsingDAOException(Throwable cause) {
        super(cause);
    }
}
