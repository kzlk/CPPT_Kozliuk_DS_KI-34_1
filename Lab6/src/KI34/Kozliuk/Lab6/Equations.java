package KI34.Kozliuk.Lab6;

/**
 * Class <code>Equations</code> implements method for sin(x)/sin(2x-4) expression
 * calculation
 *
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class Equations {
    /**
     * Method calculates the ((2 / tg(x)) / x) expression
     *
     * @param <code>x</code> Angle in degrees
     * @throws CalcException
     */
    public double calculate(double x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0;
        try {
            y = Math.sin(rad) / Math.sin(2 * rad - 4);
            // Якщо результат не є числом, то генеруємо виключення
            if (Double.isNaN(y) || y == Double.NEGATIVE_INFINITY ||
                    y == Double.POSITIVE_INFINITY || ((2 * rad) - 4) == 0)
                throw new ArithmeticException();
        } catch (ArithmeticException ex) {
            // створимо виключення вищого рівня з поясненням причини
            // виникнення помилки
            if (((2 * rad) - 4) == 0)
                throw new CalcException("Exception reason: division by zero");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
        }
        return y;
    }



}
