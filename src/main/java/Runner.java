import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Book b1 = new Book("123-123-123", "Pflanzen und Tiere");
        Book b2 = new Book("351-193-784", "Java und C++");

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(b1);
        listOfBooks.add(b2);

        GenericShelf<Book> bookShelf = new GenericShelf<>(listOfBooks);

        System.out.println("First book on Shelf: " + bookShelf.getFirst());

        System.out.println("\nPrinting the content of my Library:");
        bookShelf.printContent();

        System.out.println("\nAdding a new book to my Library...");
        bookShelf.putIntoPool(new Book("837-111-492", "Giving and Taking"));

        System.out.println("\nPrinting the content of my Library:");
        bookShelf.printContent();
    }
}
