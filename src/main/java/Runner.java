import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {
    List<Book> myBookList;

    public Runner() {
        this.myBookList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.setBookList();

        runner.simpleSearch();
        System.out.println("\n\n=========================\n\n");
        runner.searchAndReturnBook();
        System.out.println("\n\n=========================\n\n");
        runner.sortMyBookList();
        System.out.println("\n\n=========================\n\n");
        runner.dontDoSideEffects();
    }

    private void setBookList() {
        myBookList = Arrays.asList(
                new Book("Undo it", 276, true),
                new Book("Clean Architecture", 524, true),
                new Book("The Power of Now", 132, true),
                new Book("The Art of Fermentation", 785, true),
                new Book("Working out Loud", 198, true),
                new Book("The Rosie Project", 349, true),
                new Book("Clean Code", 487, true),
                new Book("Clean Architecture", 234, true),
                new Book("Clean Architecture", 34, true));
    }

    private void simpleSearch() {
        boolean foundInterestingLongRead = myBookList.stream()
                .filter(book -> book.getPages() > 200)
                .anyMatch(book -> book.isInteresting());
        System.out.println("Book found that is interesting and over 200 pages long -> " + foundInterestingLongRead);

        boolean foundOnlyLongBooks = myBookList.stream()
                .mapToInt(book -> book.getPages())
                .allMatch(pages -> pages > 100);
        System.out.println("All books in list are considered long reads -> " + foundOnlyLongBooks);

        boolean foundOnlyInterestingBooks = myBookList.stream()
                .map(book -> book.isInteresting())
                .noneMatch(interesting -> !interesting);
        System.out.println("All books are interesting -> " + foundOnlyInterestingBooks);
    }

    private void searchAndReturnBook() {
        Optional<Book> optionalBook = myBookList.stream()
                .filter(book -> book.getPages() < 200)
                .filter(book -> book.isInteresting())
                .findAny();
        optionalBook.ifPresent(System.out::println);

        System.out.println("\n----------------\n");

        Optional<Book> optionalBook2 = myBookList.stream()
                .peek(book -> System.out.println(book))
                .filter(book -> book.getPages() < 200)
                .peek(System.out::println)
                .filter(book -> book.isInteresting())
                .findAny();
        optionalBook2.ifPresent(book -> System.out.println("\nFound the Book: " + book));
    }

    private void sortMyBookList() {
        myBookList.stream().sorted().forEach(System.out::println);

        System.out.println("\n----------------\n");

        myBookList.stream().sorted((b1, b2) -> b1.getPages() - b2.getPages()).forEach(System.out::println);
//        myBookList.stream().sorted(Comparator.comparingInt(Book::getPages)).forEach(System.out::println);

        Comparator<Book> byTitle = Comparator.comparing(Book::getTitle);
        Comparator<Book> byPages = Comparator.comparing(Book::getPages);
        Comparator<Book> byInteresting = Comparator.comparing(Book::isInteresting);

        System.out.println("\n---------------- NOT SORTED\n");

        myBookList.stream().forEach(System.out::println);

        System.out.println("\n---------------- SORTED BY TITLE\n");

        myBookList.stream().sorted(byTitle).forEach(System.out::println);

        System.out.println("\n---------------- SORTED BY TITLE REVERSED\n");

        myBookList.stream().sorted(byTitle.reversed()).forEach(System.out::println);

        System.out.println("\n---------------- SORTED BY TITLE THEN BY PAGES\n");

        myBookList.stream().sorted(byTitle.thenComparing(byPages)).forEach(System.out::println);

        System.out.println("\n---------------- SORTED BY TITLE - DISTINCT ELEMENTS ONLY\n");

        myBookList.stream().map(book -> book.getTitle()).distinct().forEach(System.out::println);
    }

    private void dontDoSideEffects() {
        List<Book> myNewBookList = myBookList.stream()
                .filter(book -> book.getPages() > 300)
                .collect(Collectors.toList());

        myNewBookList.stream().forEach(System.out::println);
    }

}
