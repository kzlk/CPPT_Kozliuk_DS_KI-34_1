package KI34.Kozliuk.Lab6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Class <code>FioEquationsApp</code> Implements driver for Equations class
 * Driver for test read/write to txt/bin file
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class FioEquationsApp
{
    /**
     * Method the point to start execution program
     * @param args
     */
    public static void main(String[] args) throws IOException
    {
        try
        {
            CalcWFio rwObj = new CalcWFio();
            Scanner in = new Scanner(System.in);

            out.print("Enter X angle value in degree: >  ");
            double data = in.nextDouble();
            rwObj.calculate(data);
            out.println("Result is: " + rwObj.getResult()); //result

            rwObj.writeResTxt("textRes.txt"); //write to txt
            rwObj.writeResBin("BinRes.bin"); //write to bin

            rwObj.readResBin("BinRes.bin"); //read from bin
            out.println("Result from binary file is: " + rwObj.getResult());

            rwObj.readResTxt("textRes.txt"); //red from txt
            System.out.println("Result from txt file is : " + rwObj.getResult());

            in.close();
        }
        catch (FileNotFoundException exception)
        {
            out.println("File is not founded! " + exception.getMessage());
        }
        catch (CalcException calcException)
        {
            out.println(calcException.getMessage());
        }
    }
}

