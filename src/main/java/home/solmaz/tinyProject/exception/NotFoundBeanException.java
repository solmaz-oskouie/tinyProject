package home.solmaz.tinyProject.exception;

public class NotFoundBeanException extends RuntimeException {

    public NotFoundBeanException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotFoundBeanException(String s) {
        super(s);
    }
}
