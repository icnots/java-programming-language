package printed.material;

@SuppressWarnings("serial")
public class InvalidBookException extends Exception {
    private String author;
    private String title;

    public InvalidBookException(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}
