enum Days{
    MON("hétfő", "monday", true),          // 0
    TUE("kedd", "tuesday", true),          // 1
    WED("szerda", "wednesday", true),      // 2
    THU("csütörtök", "thursday", true),    // 3
    FRI("péntek", "friday", true),         // 4
    SAT("szombat", "saturday", false),     // 5
    SUN("vasárnap", "sunday", false);      // 6

    private String hun;
    private String eng;
    
    private boolean workingDay;
    
    Days(String hun, String eng, boolean wd){
        System.out.println("Constructor of Days running with parameters " + hun + ", " + eng);
        this.hun = hun;
        this.eng = eng;
        workingDay = wd;
    }
    
    public String getHunName(){ return hun; }
    public String getEngName(){ return eng; }
    public boolean isWorkingDay(){ return workingDay; }
    
    public static void printAll(){
    
    }
}
