package KI34.Kozliuk.Lab7;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.System.out;

/**
 * Class <code>BoxDriver</code> implements interaction with class <code>Box</code>
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class BoxDriver
{
    /**
     * Main method the entry point to start program
     * @param args
     */
    public static void main(String[] args)
    {
        Box<? super Item> bigBox = new Box<Item>();

        Sweet oreoCrumbs = new Sweet("Oreo Crushed Cookie Crumbs (No Creme)", 410);

        bigBox.addItem(new Tools("Calipers", 210, "200мм"));
        bigBox.addItem(new Tools("Roulette", 100, "7.5 м * 25 мм"));
        bigBox.addItem(new Tools("Сhisel", 180, "CR-V 22 мм"));
        bigBox.addItem(new Book("English Grammar in Use Intermediate", 100, " Antoine de Saint-Exupery", "Art" ));
        bigBox.addItem(new Sweet("Oreo Small Crushed Cookie", 400));
        bigBox.addItem(new Sweet("Toblerone White Chocolate Large Bar", 360));
        bigBox.addItem(oreoCrumbs);
        out.println("-----------------------");

        var min = bigBox.findMin();
        out.println("The element with smallest weight is : ");
        min.printInfo();

        out.println("\n====Printing=all=item=in=the==box====\n");
        bigBox.printAllArray();

        bigBox.deleteDataByObject(oreoCrumbs);
        out.println("\n====Printing=all=item=in=the==box====\n");
        bigBox.printAllArray();


        bigBox.deleteDataByIndex(1);
        out.println("\n====Printing=all=item=in=the==box====\n");
        bigBox.printAllArray();

    }
}

/**
 * Class <code>Box</code> implements Box of some items
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 * @param <T> The Type that implements interface Item
 */
class Box <T extends Item>
{
    private ArrayList<T> arr;

    /**
     * Constructor default
     */
    public Box() {arr = new ArrayList<>();}

    /**
     * Method to find items with minimal weight
     * @return Object with minimal elements
     */
    public T findMin()
    {
        if(!arr.isEmpty())
        {
            T min = arr.get(0);
            for(var i: arr)
            {
                if(i.compareTo(min) < 0)
                    min = i;
            }
            return min;
        }
        return  null;
    }

    /**
     * Method to add item to box
     * @param item Item that will be added
     */
    public void addItem(T item)
    {
        out.println("-----------------------");
        arr.add(item);
        out.println("Item added # "  + arr.size() + " :");
        item.printInfo();

    }

    /**
     * Method to pop item from box by object
     * @param item Item that will be deleted
     */
    public void deleteDataByObject(T item)
    {
        if(arr.removeIf(arr -> Objects.equals(item, arr)))
        {
            out.println("The following item deleted: " );
            item.printInfo();
        }else
        {
            out.println("Item cannot be deleted: " );
            item.printInfo();
        }

    }

    /**
     * Method to pop item from box by index
     * @param index Index of item that will be deleted
     */
    public void deleteDataByIndex(int index)
    {
        if(index > 0 && index <= arr.size())
        {
            out.println("The following item deleted ");
            arr.remove(index-1).printInfo();
        }
        else
        {
            out.println("Item cannot be deleted: " );
            arr.get(index).printInfo();
        }
    }

    /**
     * Method to view all item in the box
     */
    public void printAllArray()
    {
        int cnt = 0;
        for(var a : arr)
        {
            if(!arr.isEmpty())
            {
                out.println("Item # " + (++cnt));
                out.println("------------------------");
                a.printInfo();
                out.println("------------------------");
            }else
            {
                out.println("Box is empty");
            }
        }
    }
}

/**
 * Interface<code>Item</code> that contain method for all items
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
interface Item extends Comparable<Item>
{
    /**
     * Method to get weight of  item
     * @return The weight of item
     */
    public int getWeight();

    /**
     * Method to get info of item
     */
    public void printInfo();
}

/**
 * Class <code>Book</code> implements book
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
class Book implements Item
{
    private String bookName;
    private String genre;
    private String author;
    private int bookWeight;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookWeight() {
        return bookWeight;
    }

    public void setBookWeight(int bookWeight) {
        this.bookWeight = bookWeight;
    }

    /**
     * Сonstrucnor for initialize item
     * @param bookName The book name
     * @param bookWeight The book weight
     * @param author The book author
     * @param genre The book genre
     */
    Book(String bookName, int bookWeight, String author, String genre)
    {
        this.bookName = bookName;
        this.bookWeight = bookWeight;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public int getWeight() {return bookWeight;}

    @Override
    public void printInfo()
    {
        out.println
                ("Name: " + bookName +
                "\nAuthor: " + author +
                "\nGenre: " + genre +
                "\nWeigh: " + bookWeight
                );
    }

    @Override
    public int compareTo(Item item)
    {
        Integer cmp = bookWeight;
        return cmp.compareTo(item.getWeight());
    }
}
/**
 * Class <code>Tools</code> implements tools
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
class Tools implements Item
{
    String nameTools;

    String description;
    int weightTools;

    /**
     * Constructor to initialize Tools
     * @param nameTools The tools name
     * @param weightTools The weight tools
     * @param description The tools description
     */
    public Tools(String nameTools, int weightTools, String description)
    {
        this.nameTools = nameTools;
        this.weightTools = weightTools;
        this.description = description;
    }

    @Override
    public int getWeight()
    {
        return weightTools;
    }

    @Override
    public void printInfo()
    {
        out.println
                (
                 "Name: " + nameTools +
                 "\nDescription: " + description +
                 "\nWeigh: " + weightTools
                );
    }

    @Override
    public int compareTo(Item item)
    {
        Integer cmp = weightTools;
        return cmp.compareTo(item.getWeight());
    }
}
/**
 * Class <code> Sweets</code> implements sweets
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
class Sweet implements  Item
{
    String nameSweets;

    int weightSweet;

    /**
     * Constructor to initialize Sweets
     * @param nameSweets The sweet name
     * @param weightSweet The sweet weight
     */
    public Sweet(String nameSweets, int weightSweet)
    {
        this.nameSweets = nameSweets;
        this.weightSweet = weightSweet;
    }

    @Override
    public int getWeight() {
        return weightSweet;
    }

    @Override
    public void printInfo()
    {
        out.println
                ("Name: " + nameSweets +
                        "\nWeigh: " + weightSweet
                );
    }

    @Override
    public int compareTo(Item item)
    {
        Integer cmp = weightSweet;
        return cmp.compareTo(item.getWeight());
    }
}
