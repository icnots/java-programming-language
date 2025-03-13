package music.fan;

public class Fan {
    private final String name;
    private final music.recording.Artist favourite;
    private int moneySpent;    
    
    public String getName(){
        return name;
    }
    
    public music.recording.Artist getFavourite(){
        return favourite;
    }
    
    public int getMoneySpent(){
        return moneySpent;
    }
    
    public Fan(String name, music.recording.Artist favourite){
        this.name = name;
        this.favourite = favourite;
        this.moneySpent = 0;
    }
    
    public int buyMerchandise(int basePrice, Fan... friends){
        // Suppose that each friend has the same favourite...        
        int discountAmount = friends.length > 1 ? 20 : 10 * friends.length;
        int discountedPrice = basePrice * (100 - discountAmount) / 100;
        
        favourite.getLabel().gotIncome((friends.length + 1) * discountedPrice / 2);
        
        this.moneySpent += discountedPrice;
        for (Fan friend : friends){
            friend.moneySpent += discountedPrice;
        }
        
        return discountedPrice;
    }
    
    public boolean favesAtSameLabel(Fan fan){
        return fan.favourite.getLabel().equals(this.favourite.getLabel());
    }
    
    public String toString1(){
        // "Fan(name=F, fave=A@X, spent=0)"
        return "Fan(name=" + name + ", fave=" + favourite.getName() + "@" + favourite.getLabel().getName() + ", spent=" + moneySpent + ")";
    }
    
    public String toString2(){
        return "Fan(name=%s, fave=%s@%s, spent=%d)".formatted(name, favourite.getName(), favourite.getLabel().getName(), moneySpent);
    }
    
    public String toString3(){
        return String.format("Fan(name=%s, fave=%s@%s, spent=%d)", name, favourite.getName(), favourite.getLabel().getName(), moneySpent);
    }
    
    public String toString4(){
        StringBuilder sb = new StringBuilder();
        sb.append("Fan(name=");
        sb.append(name);
        sb.append(", fave=");
        sb.append(favourite.getName());
        sb.append("@");
        sb.append(favourite.getLabel().getName());
        sb.append(", spent=");
        sb.append(moneySpent);
        sb.append(")");
        return sb.toString();
    }
}
