package printed.material;

public class Book{
    public static final String defaultAuthor = "John Steinbeck";
    public static final String defaultTitle = "Of Mice and Men";
    public static final int defaultPageCount = 107;

    private String author;
    public String getAuthor(){
        return author;
    }
    private String title;
    public String getTitle(){
        return title;
    }
    protected int pageCount;
    public int getPageCount(){
        return pageCount;
    }

    public Book() throws InvalidBookException{
        // egyik lehetőség:
        this(defaultAuthor, defaultTitle, defaultPageCount);
        
        // másik lehetőség:
        // feltételezhetjük, hogy jók a default értékek, így rögtön hívhatjuk az inicializálást is
        initBook(defaultAuthor, defaultTitle, defaultPageCount);
    }

    public Book(String author, String title, int pageCount) throws InvalidBookException{
        checkInitData(author, title, pageCount);
        initBook(author, title, pageCount);
    }

    private void checkInitData(String author, String title, int pageCount) throws InvalidBookException{
        if (author.length() < 2 || title.length() < 4 || pageCount < 1){
            //throw new IllegalArgumentException() // feladat leírása szerint.
            throw new InvalidBookException(author, title);
        }
    }

    public String createReference(String name, int i1, int i2){
        return "Hello World!";
    }

    public static Book decode(String text) throws InvalidBookException{
        String[] items = text.split("[:;]");
        String authorName = items[0].strip();
        String titleName = items[1].strip();
        int pc = Integer.parseInt(items[2].strip());

        return new Book(authorName, titleName, pc);
    }

    protected String getAuthorWithInitials(){
        StringBuilder sb = new StringBuilder();
        String[] names = author.split(" ");
        for (int i = 0; i < names.length - 1; i++){
            String name = names[i].strip();
            sb.append(name.charAt(0));
            sb.append(". ");
        }
        sb.append(names[names.length-1].strip());

        return sb.toString();
    }

    public int getPrice(){
        return pageCount;
    }

    public String getShortInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(getAuthorWithInitials());
        sb.append(": ");
        sb.append(title.substring(0,4));
        sb.append("; ");
        sb.append(pageCount);

        return sb.toString();
    }

    protected void initBook(String author, String title, int pageCount){
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(author);
        sb.append(": ");
        sb.append(title);
        sb.append("; ");
        sb.append(pageCount);

        return sb.toString();
    }
}