package KI34.Kozliuk.Lab6;

/**
 * Class <code>CalcException</code> more precises ArithmeticException
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class CalcException extends ArithmeticException {
    public CalcException() {}
    public CalcException(String cause) {
        super(cause);
    }
}
