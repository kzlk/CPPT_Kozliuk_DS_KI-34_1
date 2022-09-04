package KI34.Kozliuk.Lab4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class VideoCamera extends Camera implements IRecorder, Printable, IPromptableKey
{

    private StopWatch watcher;

    private ArrayList<Particle> videoList;

    /**
     * Default constructor
     * @throws FileNotFoundException
     */
    public VideoCamera() throws FileNotFoundException
    {
        super();
        videoList = new ArrayList<>();
    }

    /**
     * Constructor to initialize data from file
     * @param name Name of camera
     * @throws IOException
     */
    public VideoCamera(String name) throws IOException
    {
        super(name);
        videoList = new ArrayList<>();
    }

    /**
     * Consctucor to initialize name and firm camera
     * @param name Name of camera
     * @param firm Firm of camera
     * @throws FileNotFoundException
     */
    public VideoCamera(String name, String firm) throws FileNotFoundException
    {
        super(name, firm);
        videoList = new ArrayList<>();
    }

    /**
     * Method to recording in new thread
     * @param resolution
     * @param fps
     * @throws InterruptedException
     */
    @Override
    public void startRecord(String resolution, int fps) throws InterruptedException
    {
        watcher = new StopWatch();
        System.out.print("Recording is starting...\n");
        watcher.start();
        if(IPromptableKey.promptEnterKey())
        {
            stopRecord();
            System.out.println("Recording is stopping...");
        }
        watcher.join();
        var sizeV = sizeOfVideo(resolution, fps);
        if(sizeV != -1 )
        {
            videoList.add(new Video(new Date(), sizeV, "mkv", resolution, fps));
            updateMemorySize(videoList);
        }else
        {
            System.out.println("Size is NULL!");
        }



    }

    /**
     * Method to stop recording
     */
    @Override
    public void stopRecord() {watcher.setTimerStart(false);}

    /**
     * Method to get size of video
     * @param resolution
     * @param fps
     * @return
     */
    @Override
    public double sizeOfVideo(String resolution, int fps)
    {
        for( var a : Video.RESOLUTION.values())
        {
            for(var b: Video.FPS.values())
            {
                if(Objects.equals(a.getValue(), resolution) && b.getValue() == fps)
                {
                    for(var c : Video.COEFFICIENT_FPS.values() )
                    {
                        for(var d : Video.COEFFICIENT_RESOLUTION.values())
                        {
                            if(Objects.equals(a.name(), d.name()) && b.name().equals(c.name()))
                            {
                                return watcher.sec * c.getValue() * d.getValue();
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    /**
     *Method to print all video
     */
    @Override
    public void printData()
    {
        DecimalFormat dec = new DecimalFormat("#0.00");
        formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println("Name    \t" + "     Date               \t" + "\tSize(Mb)\t" + "    Format\t" + " \t\t Resolution" + "\t\t FPS");
        for (var photo : videoList) {
            System.out.println(photo.name + '\t' + formatter.format(photo.date) + "\t\t\t" + dec.format(photo.sizeMb) + "\t\t\t" + photo.format + "\t\t\t\t" + photo.resolution + "\t\t     " + photo.fps);
        }

    }
}

/**
 * Class <code>Video</code> implements video for video camera
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
class Video extends Particle
{
    enum COEFFICIENT_FPS
    {
        FPS30(1) , FPS60(2), FPS120(4);

        private final int value;
        COEFFICIENT_FPS(int i)
        {
            this.value = i;
        }

        public int getValue()
        {
            return value;
        }
    }
    enum COEFFICIENT_RESOLUTION
    {
        P1080(4), P720(2), P480(1), K2(6), K4(10);
        private final int value;
        COEFFICIENT_RESOLUTION(int i)
        {
            this.value = i;
        }

        public int getValue()
        {
            return value;
        }
    }

    enum FPS
    {
        FPS30(30) , FPS60(60), FPS120(120);

        private final  int value;

        FPS( int value) {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

    enum  RESOLUTION
    {
        P1080("1080P"), P720("720P"), P480("480P"), K2("2K"), K4("4K");
        private final String value;
        RESOLUTION(String i)
        {
            this.value = i;
        }

        public String getValue()
        {
            return value;
        }
    }

    /**
     * Constructor
     * The default initialization
     */
    Video()
    {
        date = new Date();
        format = null;
        sizeMb = (double) 0;
        name = null;
        resolution = null;
        fps = 0;
    }

    /**
     * Constructor for initialize data of video
     * @param date
     * @param sizeMb
     * @param format
     * @param resolution
     * @param fps
     */
    Video(Date date, Double sizeMb, String format, String resolution, int fps)
    {
        this.format = format;
        this.date = date;
        this.sizeMb = sizeMb;
        this.name = "untitledVideo" + itemCount.toString();
        this.resolution = resolution;
        this.fps = fps;
        itemCount++;
    }
}
