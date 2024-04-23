package printed.material;

public class Book {
    public static final String defaultAuthor = "John Steinbeck";
    public static final String defaultTitle = "Of Mice and Men";
    public static final int defaultPageCount = 107;

    private String author;
    private String title;
    protected int pageCount;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Book() {
        initBook(defaultAuthor, defaultTitle, defaultPageCount);
    }

    public Book(String author, String title, int pageCount) throws InvalidBookException {
        checkInitData(author, title, pageCount);
        initBook(author, title, pageCount);
    }

    private void checkInitData(String author, String title, int pageCount) throws InvalidBookException {
        if (author.length() < 2 || title.length() < 4 || pageCount < 1) {
            throw new InvalidBookException(author, title);
        }
    }

    protected void initBook(String author, String title, int pageCount) {
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
    }

    protected String getAuthorWithInitials() {
        String[] nameParts = author.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nameParts.length-1; i++) {
            sb.append(nameParts[i].charAt(0) + ". ");
        }
        sb.append(nameParts[nameParts.length-1]);

        return sb.toString();
    }

    public int getPrice() {
        return getPageCount();
    }

    @Override
    public String toString() {
        return "%s: %s; %d".formatted(author, getTitle(), getPageCount());
    }

    public String getShortInfo() {
        return "%s: %s; %d".formatted(getAuthorWithInitials(), getTitle().substring(0, 4), getPageCount());
    }

    public String createReference(String article, int from, int to) {
        return "%s [%s-%s] referenced in article: %s".formatted(getShortInfo(), from, to, article);
    }

    public static Book decode(String text) throws InvalidBookException {
        String[] split1 = text.split(":");
        String[] split2 = split1[1].split(";");

        String author = split1[0].strip();
        String title = split2[0].strip();
        int pageCount = Integer.parseInt(split2[1].strip());

        try {
            return new Book(author, title, pageCount);
        } catch (InvalidBookException e) {
            // ignored
            throw new IllegalArgumentException();
        }
    }
}
