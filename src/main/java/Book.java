
public class Book implements Comparable<Book> {
    private String title;
    private String genre;
    private int pages;
    private boolean interesting;

    public Book(String title, String genre, int pages, boolean interesting) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
        this.interesting = interesting;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isInteresting() {
        return interesting;
    }

    public void setInteresting(boolean interesting) {
        this.interesting = interesting;
    }

    @Override
    public String toString() {
        if(interesting) {
            return "\"" + title + "\" with " + pages + " pages. And yes, it's super interesting";
        } else {
            return "\"" + title + "\" with " + pages + " pages. And no, it's absolutely boring";
        }
    }

    @Override
    public int compareTo(Book o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
