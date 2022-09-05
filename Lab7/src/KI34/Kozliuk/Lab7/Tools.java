package KI34.Kozliuk.Lab7;

import static java.lang.System.out;

/**
 * Class <code>Tools</code> implements tools
 *
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
public class Tools implements Item {
    String nameTools;

    String description;
    int weightTools;

    /**
     * Constructor to initialize Tools
     *
     * @param nameTools   The tools name
     * @param weightTools The weight tools
     * @param description The tools description
     */
    public Tools(String nameTools, int weightTools, String description) {
        this.nameTools = nameTools;
        this.weightTools = weightTools;
        this.description = description;
    }

    @Override
    public int getWeight() {
        return weightTools;
    }

    @Override
    public void printInfo() {
        out.println
                (
                        "Name: " + nameTools +
                                "\nDescription: " + description +
                                "\nWeigh: " + weightTools
                );
    }

    @Override
    public int compareTo(Item item) {
        Integer cmp = weightTools;
        return cmp.compareTo(item.getWeight());
    }
}
