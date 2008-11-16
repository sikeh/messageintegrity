package se.kth.seds.mi.core.exceptions;

/**
 * The required operation failed.
 *
 * @author Shanbo Li
 */
public class OperationFailedException extends Exception{
    private static final long serialVersionUID = -3654943611207641491L;

    public OperationFailedException() {
    }

    public OperationFailedException(String message) {
        super(message);
    }

    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationFailedException(Throwable cause) {
        super(cause);
    }
}
