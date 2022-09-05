package KI34.Kozliuk.Lab6;

import java.io.*;
import java.util.*;

/**
 * Class <code>CalcWFio</code> for read/write result of class <code>Equations</code>
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class CalcWFio
{
    /**
     * Method to write in text file
     * @param fName The file name
     * @throws FileNotFoundException
     */
    public void writeResTxt(String fName) throws FileNotFoundException
    {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ",result);
        f.close();
    }

    /**
     * Method to read from text file
     * @param fName The file name
     */
    public void readResTxt(String fName) throws FileNotFoundException
    {

            File f = new File (fName);
            Scanner s = new Scanner(f);
            result = s.nextDouble();
            s.close();

    }

    /**
     * Method to write result to binary file
     * @param fName The file name
     * @throws IOException
     */
    public void writeResBin(String fName) throws IOException
    {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();

    }

    /**
     *  Method to read from binary file
     * @param fName The file name
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException
    {

        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    /**
     * Method to calculate equations
     * @param x The angle in degree
     */
    public void calculate(double x)
    {
        result = new Equations().calculate(x);
    }

    /**
     * Getter for result
     * @return The result of calculation
     */
    public double getResult()
    {
        return result;
    }
    private double result;
}