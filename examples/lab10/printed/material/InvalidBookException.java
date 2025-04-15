package printed.material;

public class InvalidBookException extends Exception{
    private String author;
    private String title;

    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }

    public InvalidBookException(String author, String title){
        this.author = author;
        this.title = title;
    }
}