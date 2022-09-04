package KI34.Kozliuk.Lab4;

import java.io.IOException;

/**
 * Interface that have some prompt key
 */
public interface IPromptableKey
{
     static boolean promptEnterKey()
     {
        System.out.println("Press \"ENTER\" to stop recording video...");
        try {
            System.in.read();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
