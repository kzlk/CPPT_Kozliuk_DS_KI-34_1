package KI34.Kozliuk.Lab7;

import static java.lang.System.out;

/**
 * Class <code> Sweets</code> implements sweets
 *
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class Sweet implements Item {
    String nameSweets;

    int weightSweet;

    /**
     * Constructor to initialize Sweets
     *
     * @param nameSweets  The sweet name
     * @param weightSweet The sweet weight
     */
    public Sweet(String nameSweets, int weightSweet) {
        this.nameSweets = nameSweets;
        this.weightSweet = weightSweet;
    }

    @Override
    public int getWeight() {
        return weightSweet;
    }

    @Override
    public void printInfo() {
        out.println
                ("Name: " + nameSweets +
                        "\nWeigh: " + weightSweet
                );
    }

    @Override
    public int compareTo(Item item) {
        Integer cmp = weightSweet;
        return cmp.compareTo(item.getWeight());
    }
}
