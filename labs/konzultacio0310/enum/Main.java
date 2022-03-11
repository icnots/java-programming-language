class Main{
    public static void main (String[] args){
        System.out.println("Main is starting.");
        
        Days day = Days.MON;
        
        System.out.println(day.getEngName() + "'s name in Hungarian : " + day.getHunName());
        
        for (Days currentDay : Days.values()){
            day = currentDay;
            System.out.println(day.getEngName() + "'s name in Hungarian : " + day.getHunName());
        }
        
        Day d = Day.MON();
        
        System.out.println(d.eng + "'s name in Hungarian : " + d.hun);
        
        Day d2 = Day.MON();
    
    }

}



