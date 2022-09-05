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

