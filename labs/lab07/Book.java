class Book{

    private Book(String author, String title){
        this.author = author;
        this.title = title;
    }

    public static Book makeFromAuthor(String author){
        return new Book(author, "untitled");
    }
    public static Book makeFromTitle(String title){
        return new Book("No author", title);
    }
    
}
