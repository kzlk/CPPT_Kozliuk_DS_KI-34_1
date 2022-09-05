package KI34.Kozliuk.Lab7;

import static java.lang.System.out;

/**
 * Class <code>Book</code> implements book
 *
 * @author Kozliuk Dmytro KI-34
 * @version 1.0
 */
class Book implements Item {
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
     *
     * @param bookName   The book name
     * @param bookWeight The book weight
     * @param author     The book author
     * @param genre      The book genre
     */
    Book(String bookName, int bookWeight, String author, String genre) {
        this.bookName = bookName;
        this.bookWeight = bookWeight;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public int getWeight() {
        return bookWeight;
    }

    @Override
    public void printInfo() {
        out.println
                ("Name: " + bookName +
                        "\nAuthor: " + author +
                        "\nGenre: " + genre +
                        "\nWeigh: " + bookWeight
                );
    }

    @Override
    public int compareTo(Item item) {
        Integer cmp = bookWeight;
        return cmp.compareTo(item.getWeight());
    }
}
