import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Test
{
    public static boolean promptEnterKey()
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
    public static void main(String[] args) throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        StopWatch thread = new StopWatch();
        thread.start();

        if (promptEnterKey())
        {
            thread.setTimerStart(false);
        }
        var a = thread.getWriteThis();
        System.out.println("Time = " + a);

        thread.join();
    }
}


interface Watcher
{
    int msInSec = 1000;
    int secInMinute = 60;
    int secInHours = 3600;
    void startStopWatch();
}

class StopWatch extends Thread implements Watcher
{
    public boolean isTimerStart()
    {
        return isTimerStart;
    }

    public void setTimerStart(boolean timerStart)
    {
        isTimerStart = timerStart;
    }

    private boolean isTimerStart;

    public String getWriteThis() {return writeThis;}

    public void setWriteThis(String writeThis) {
        this.writeThis = writeThis;
    }

    private String writeThis;

    StopWatch() {this.isTimerStart = true;}

    @Override
    public void run() {startStopWatch();}

    @Override
    public void startStopWatch() {
        int charsWritten = 0;
        long start = System.currentTimeMillis();
        while (isTimerStart)
        {
            try
            {
                Thread.sleep(msInSec);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            long elapsedTime = System.currentTimeMillis() - start;
            elapsedTime = elapsedTime / 1000;

            String seconds = Integer.toString((int) (elapsedTime % secInMinute));
            String minutes = Integer.toString((int) ((elapsedTime % secInHours) / secInMinute));
            String hours = Integer.toString((int) (elapsedTime / secInHours));

            if (seconds.length() < 2) {
                seconds = "0" + seconds;
            }

            if (minutes.length() < 2) {
                minutes = "0" + minutes;
            }

            if (hours.length() < 2) {
                hours = "0" + hours;
            }

            writeThis = hours + ":" + minutes + ":" + seconds;

            for (int i = 0; i < charsWritten; i++) {
                System.out.print("\b");
            }
            System.out.print(writeThis);
            charsWritten = writeThis.length();


        }

    }

}


