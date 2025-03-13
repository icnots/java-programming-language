package music.recording;

public class Artist {
    private final String name;
    private final RecordLabel label;
    
    public String getName(){
        return name;
    }
    
    public RecordLabel getLabel(){
        return label;
    }
    
    public Artist(String name, RecordLabel label){
        this.name = name;
        this.label = label;
    }
}
