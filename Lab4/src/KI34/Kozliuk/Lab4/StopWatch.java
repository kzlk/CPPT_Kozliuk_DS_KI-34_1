package KI34.Kozliuk.Lab4;

/**
 * Class <code>StopWatch</code> implements stopwatch
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class StopWatch extends Thread implements Watcher
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

    protected int sec = 0;

    public String getWriteThis() {return writeThis;}

    public void setWriteThis(String writeThis) {
        this.writeThis = writeThis;
    }

    private String writeThis;

    StopWatch() {this.isTimerStart = true;}

    /**
     * Override method to start stop watch in new thread
     */
    @Override
    public void run() {startStopWatch();}

    /**
     * Method to start stop watch
     */
    @Override
    public void startStopWatch()
    {
        sec = 0;
        int charsWritten = 0;
        long start = System.currentTimeMillis();
        while (isTimerStart)
        {
            try
            {
                Thread.sleep(msInSec);
                sec++;
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
