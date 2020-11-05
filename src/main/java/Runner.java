import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

        runner.collectIntro();

        System.out.println("\n====================\n");

        runner.groupBySimple();

        System.out.println("\n====================\n");

        runner.partitionBy();

        System.out.println("\n====================\n");

        runner.summingAndAveraging();

        System.out.println("\n====================\n");

        runner.remainingMethods();

        System.out.println("\n====================\n");


    }

    private void setBookList() {
        myBookList = Arrays.asList(
                new Book("Undo it", "life", 276, true),
                new Book("Clean Architecture", "tech", 524, true),
                new Book("The Power of Now", "life", 132, false),
                new Book("The Art of Fermentation", "life", 785, true),
                new Book("Working out Loud", "work", 198, true),
                new Book("The Rosie Project", "life", 349, true),
                new Book("Black Matter", "tech", 132, true),
                new Book("Mani Matter", "life", 276, true),
                new Book("Clean Code", "tech", 487, true),
                new Book("Clean Architecture","tech",  234, false),
                new Book("Clean Architecture", "tech", 34, false));
    }

    private void collectIntro() {
        List<Book> newBookList = myBookList.stream()
                .filter(book -> book.getPages() > 200)
                .collect(Collectors.toList());
//        System.out.println(newBookList);
        for(Book book : newBookList) {
            System.out.println(book);
        }

        System.out.println("\n-----------------\n");

        List<Book> newBookList2 = myBookList.stream()
                .filter(book -> book.getPages() > 300)
                // toCollection takes a Supplier (!!) or a constructor / method reference
                .collect(Collectors.toCollection(() -> new ArrayList<Book>()));
//                .collect(Collectors.toCollection(ArrayList::new));
        for(Book book : newBookList2) {
            System.out.println(book);
        }
    }

    /**
     * Collectors.groupingBy(--FUNCTION--)
     * Interface Function<T,R> { R apply(T t); }
     */
    private void groupBySimple() {
        Map<Boolean, List<Book>> booksSortedByInteresting = myBookList.stream().collect(Collectors.groupingBy(Book::isInteresting));
        System.out.println(booksSortedByInteresting);

        System.out.println("\n-----------------\n");

        Map<Integer, List<Book>> booksSortedByPages = myBookList.stream().collect(Collectors.groupingBy(Book::getPages));
        System.out.println(booksSortedByPages);
    }

    /**
     * Collectors.partitionBy(--PREDICATE--)
     * Interface Predicate<T> { boolean test(T t); }
     */
    private void partitionBy() {
        Map<Boolean, List<Book>> booksLongerThan300 = myBookList.stream().collect(Collectors.partitioningBy(book -> book.getPages() > 300));
        System.out.println("Books longer than 300 pages: " + booksLongerThan300);
    }

    private void summingAndAveraging() {
        Map<String, Integer> sumPages = myBookList.stream().filter(book -> book.isInteresting()).collect(Collectors.groupingBy(Book::getGenre, Collectors.summingInt(Book::getPages)));
        System.out.println("Total Pages by Genre: " + sumPages);

        System.out.println("\n-----------------\n");

        Map<String, Double> avgPages = myBookList.stream().filter(book -> book.isInteresting()).collect(Collectors.groupingBy(Book::getGenre, Collectors.averagingDouble(Book::getPages)));
        System.out.println("Average Pages by Genre: " + avgPages);

    }

    private void remainingMethods() {
        String allInterestingBooks = myBookList.stream().filter(book -> book.isInteresting()).map(Book::getTitle).collect(Collectors.joining("; "));
        System.out.println("The interesting ones: " + allInterestingBooks);

        System.out.println("\n-----------------\n");

        Optional<Book> longestBook = myBookList.stream().collect(Collectors.maxBy((b1, b2) -> b1.getPages()- b2.getPages()));
        longestBook.ifPresent(book -> System.out.println("Longest book is: " + book.getTitle() + " with " + book.getPages() + " pages!"));
    }

}
