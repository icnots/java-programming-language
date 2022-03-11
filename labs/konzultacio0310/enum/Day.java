class Day{

    String hun;
    String eng;
    
    boolean wd;
    
    static Day hetfo = null;
    
    private Day(String hun, String eng, boolean wd){
        System.out.println("Constructor of Day running with parameters " + hun + ", " + eng);
        this.hun = hun;
        this.eng = eng;
        this.wd = wd;
    }

    static Day MON(){
        if (hetfo == null){
            hetfo = new Day("hétfő", "monday", true);
            return hetfo;
        }else{
            return hetfo;
        }
    }
    
    /* .. other days .. */
    
}

