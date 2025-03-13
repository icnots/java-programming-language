package music.recording;

public class RecordLabel {
    private final String name;
    private int cash;
    
    public String getName(){
        return name;
    }
    
    public int getCash(){
        return cash;
    }
    
    public RecordLabel(String name, int cash){
        this.name = name;
        this.cash = cash;
    }
    
    public void gotIncome(int sum){
        cash += sum;
    }
}
