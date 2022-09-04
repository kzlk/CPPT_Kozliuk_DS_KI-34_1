package KI34.Kozliuk.Lab4;

import java.util.Date;

/**
 * Abstract class <code>Particle</code> implements parameters for photo and video
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public abstract class Particle
{
    static Integer itemCount = 0;
    public int fps;
    public String resolution;
    Date date;
    String format;
    Double sizeMb;
    String name;

}
