package KI34.Kozliuk.Lab7;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.System.out;

/**
 * Class <code>Box</code> implements Box of some items
 *
 * @param <T> The Type that implements interface Item
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class Box<T extends Item> {
    private ArrayList<T> arr;

    /**
     * Constructor default
     */
    public Box() {
        arr = new ArrayList<>();
    }

    /**
     * Method to find items with minimal weight
     *
     * @return Object with minimal elements
     */
    public T findMin() {
        if (!arr.isEmpty()) {
            T min = arr.get(0);
            for (var i : arr) {
                if (i.compareTo(min) < 0)
                    min = i;
            }
            return min;
        }
        return null;
    }

    /**
     * Method to add item to box
     *
     * @param item Item that will be added
     */
    public void addItem(T item) {
        out.println("-----------------------");
        arr.add(item);
        out.println("Item added # " + arr.size() + " :");
        item.printInfo();

    }

    /**
     * Method to pop item from box by object
     *
     * @param item Item that will be deleted
     */
    public void deleteDataByObject(T item) {
        if (arr.removeIf(arr -> Objects.equals(item, arr))) {
            out.println("The following item deleted: ");
            item.printInfo();
        } else {
            out.println("Item cannot be deleted: ");
            item.printInfo();
        }

    }

    /**
     * Method to pop item from box by index
     *
     * @param index Index of item that will be deleted
     */
    public void deleteDataByIndex(int index) {
        if (index > 0 && index <= arr.size()) {
            out.println("The following item deleted ");
            arr.remove(index - 1).printInfo();
        } else {
            out.println("Item cannot be deleted: ");
            arr.get(index).printInfo();
        }
    }

    /**
     * Method to view all item in the box
     */
    public void printAllArray() {
        int cnt = 0;
        for (var a : arr) {
            if (!arr.isEmpty()) {
                out.println("Item # " + (++cnt));
                out.println("------------------------");
                a.printInfo();
                out.println("------------------------");
            } else {
                out.println("Box is empty");
            }
        }
    }
}
