package zw.co.hitrac.jaxcsd.api;

/**
 *
 * @author Charles Chigoriwa
 */
public class JaxcsdRuntimeException extends RuntimeException{

    public JaxcsdRuntimeException() {
    }

    public JaxcsdRuntimeException(String message) {
        super(message);
    }

    public JaxcsdRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JaxcsdRuntimeException(Throwable cause) {
        super(cause);
    }

    public JaxcsdRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
