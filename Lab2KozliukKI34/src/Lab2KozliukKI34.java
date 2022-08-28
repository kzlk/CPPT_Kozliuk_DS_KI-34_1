import java.io.*;
import java.util.*;

/**
 * Class Lab2KozliukKI34 that realize tasks from laboratory work 2 (variant 8)
 *
 * @author Dmytro Kozliuk KI-34
 * @version 1.0
 * @since version 1.0
 *
 */
public class Lab2KozliukKI34
{
    /**
     * The static main method is the entry point to the programs
     *
     * @param args
     * @throws FileNotFoundException
     *
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("Lab2_Kozliuk.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();
        arr = new char[nRows][];

        //create jagged array
        for(int i = 0; i < nRows ; ++i)
            if(i >= nRows/2)
                arr[i] = new char[nRows - i];
            else
                arr[i] = new char[i + 1];


        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();
        exit:
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length; j++)
            {
                if(filler.length() == 1)
                {
                    if (j >= i && j >= arr.length - i - 1)
                    {
                        arr[i][nRows - j - 1] = (char) filler.codePointAt(0);
                        System.out.print( arr[i][nRows - j - 1] + " ");
                        fout.print(arr[i][nRows - j - 1] + " ");
                    }
                    else
                    {
                        fout.print("  ");
                        System.out.print("  ");
                    }
                }
                else if (filler.length() == 0)
                {
                    System.out.print("\nНе введено символ заповнювач");
                    break exit;
                }
                else
                {
                    System.out.print("\nЗабагато символів заповнювачів");
                    break exit;
                }
            }
            System.out.print("\n");
            fout.print("\n");
        }
        fout.flush();
        fout.close();
    }
}
