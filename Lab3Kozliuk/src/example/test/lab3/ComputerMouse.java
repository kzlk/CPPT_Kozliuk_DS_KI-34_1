/**
 * lab 3 package
 */
package example.test.lab3;
import java.io.*;
/**
 * Class <code>ComputerMouse</code> implements computer mouse
 * @author EOM Stuff
 * @version 1.0
 */
public class ComputerMouse {
    private Scroller scrollerDevice;
    private RelativePosition pos;
    private Button rightButton;
    private Button leftButton;
    private PrintWriter fout;
    /**
     * Constructor
     * @throws FileNotFoundException
     */
    public ComputerMouse() throws FileNotFoundException
    {
        scrollerDevice = new Scroller();
        pos = new RelativePosition();
        rightButton = new Button();
        leftButton = new Button();
        fout = new PrintWriter(new File("Log.txt"));
    }
    /**
     * Constructor
     * @param <code>resource</code> Button clicks resource
     * @throws FileNotFoundException
     */
    public ComputerMouse(int resource) throws FileNotFoundException
    {
        scrollerDevice = new Scroller();
        pos = new RelativePosition();
        rightButton = new Button(resource);
        leftButton = new Button(resource);
        fout = new PrintWriter(new File("Log.txt"));
    }
    /**
     * Method implements mouse position offset on (xPos, yPos)
     * @param <code>xPos</code> The X coordinate of the mouse position
     * @param <code>yPos</code> The Y coordinate of the mouse position
     */
    public void moveMouseOnDistance(int xPos, int yPos)
    {
        pos.setXPosition(pos.getXPosition() + xPos);
        pos.setYPosition(pos.getYPosition() + yPos);
        fout.print("New mouse X position: " + pos.getXPosition() + "\n");
        fout.print("New mouse Y position: " + pos.getYPosition() + "\n");
    }
    /**
     * Method sets the new mouse position
     * @param <code>xPos</code> The X coordinate of the mouse position
     * @param <code>yPos</code> The Y coordinate of the mouse position
     */
    public void setMousePosition(int xPos, int yPos)
    {
        pos.setXPosition(xPos);
        pos.setYPosition(yPos);
    }
    /**
     * Method returns mouse's current X position
     * @return Mouse's current X position
     */
    public int getMouseXPosition()
    {
        return pos.getXPosition();
    }
    /**
     * Method returns mouse's current Y position
     * @return Mouse's current Y position
     */
    public int getMouseYPosition()
    {
        return pos.getYPosition();
    }
    /**
     * Method simulates mouse's right button clicking
     */
    public void clickRightButton()
    {
        rightButton.clickButton();
        fout.print("New mouse's right button resource: " +
                rightButton.getButtonResourse() + "\n");
        fout.flush();
    }
    /**
     * Method simulates mouse's left button clicking
     */
    public void clickLeftButton()
    {
        leftButton.clickButton();
        fout.print("New mouse's left button resource: " +
                leftButton.getButtonResourse() + "\n");
        fout.flush();
    }
    /**
     * Method returns mouse's right button clicking resource
     * @return Mouse's right button clicking resource
     */
    public int getRightButtonResource()
    {
        return rightButton.getButtonResourse();
    }
    /**
     * Method returns mouse's left button clicking resource
     * @return Mouse's left button clicking resource
     */
    public int getLeftButtonResource()
    {
        return leftButton.getButtonResourse();
    }
/**
 * Method simulates mouse's scrolling up
 */
public void scrollUp()
{
    scrollerDevice.setUpDirection();
    fout.print("Mouse scrolled up\n");
    fout.flush();
}
    /**
     * Method simulates mouse's scrolling down
     */
    public void scrollDown()
    {
        scrollerDevice.setDownDirection();
        fout.print("Mouse scrolled down\n");
        fout.flush();
    }
    /**
     * Method simulates mouse's scroller setting in a neutral position
     */
    public void resetScroller()
    {
        scrollerDevice.resetScrooller();
        fout.print("Mouse scroller in neutral state");
        fout.flush();
    }
    /**
     * Method returns mouse's scrolling direction
     * @return Mouse's scrolling direction of
    <code>Scrooller.Directions</code> type
     */
    public Scroller.Directions getScrollingDirection()
    {
        return scrollerDevice.getDirection();
    }
    /**
     * Method releases used recourses
     */
    public void dispose()
    {
        fout.close();
    }
}
class Scroller
{
    // Type for scrolling directions
    enum Directions {NEUTRAL, UP, DOWN};
    // current scroller's state
    private Directions direction;
    /**
     * Constructor
     */
    public Scroller()
    {
        direction = Directions.NEUTRAL;
    }
    /**
     * Method sets up scrolling direction
     */
    public void setUpDirection()
    {
        direction = Directions.UP;
    }
    /**
     * Method sets neutral scrolling direction
     */
    public void setNeutralDirection()
    {
        direction = Directions.NEUTRAL;
    }
    /**
     * Method sets down scrolling direction
     */
    public void setDownDirection()
    {
        direction = Directions.DOWN;
    }
    /**
     * Method resets scrolling direction to neutral state
     */
    public void resetScrooller()
    {
        setNeutralDirection();
    }
    /**
     * Method returns scrolling direction
     * @return Scrolling direction of <code>Scrooller.Directions</code> type
     */
    public Directions getDirection()
    {
        return direction;
    }
}
/**
 * Class <code>RelativePosition</code> implements relative positioning
 coordinate system
 *
 * @author EOMStuff
 * @version 1.0
 */
class RelativePosition
{
    // coordinates of the mouse position
    private int x, y;
    /**
     * Constructor
     */
    public RelativePosition()
    {
        x = 0;
        y = 0;
    }
    /**
     * Constructor
     * @param <code>xPos</code> The X coordinate value
     * @param <code>yPos</code> The Y coordinate value
     */
    public RelativePosition(int xPos, int yPos)
    {
        x = xPos;
        y = yPos;
    }
    /**
     * Method returns the X coordinate value
     * @return The X coordinate value
     */
    public int getXPosition()
    {
        return x;
    }
    /**
     * Method returns the Y coordinate value
     * @return The Y coordinate value
     */
    public int getYPosition()
    {
        return y;
    }
    /**
     * Method returns coordinates of the position in the <code>obj</code>,
     that is passed into method through method parameter
     * @param <code>obj</code> The object, where coordinates of the current
    position are set
     */
    public void getPosition(RelativePosition obj)
    {
        obj.x = x;
        obj.y = y;
    }
    /**
     * Method sets the X coordinate value
     * @param <code>xPos</code> The X coordinate value
     */
    public void setXPosition(int xPos)
    {
        x = xPos;
    }
    /**
     * Method sets the Y coordinate value
     * @param <code>yPos</code> The Y coordinate value
     */
    public void setYPosition(int yPos)
    {
        y = yPos;
    }
}
