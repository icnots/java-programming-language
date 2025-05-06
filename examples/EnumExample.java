public enum EnumExample{
    // Amikor felsoroljuk a tagokat, lehet megadni konstruktorhívással, hogy milyen paraméterekkel fusson le a konstruktor.
    TEN(10),
    HUNDRED(100),
    THOUSAND(1000),
    ONE(1);

    // Lehetnek mezők
    private int value;
    
    // Lehet konstruktora
    EnumExample(int value){
        this.value = value;
    }
    
    // Lehetnek metódusai
    public void printValue(){
        System.out.println("Value: " + value);
    }
    
    // Lehet main metódusai is:
    public static void main(String[] args){
        System.out.println("Hello");
        
        // Értékül adhatjuk mint a sima enum-okat.
        EnumExample ex1 = EnumExample.HUNDRED;
        
        // Kiírhatjuk az értékét
        System.out.println("Ordinal of " + ex1 + " is " + ex1.ordinal());
        // Más az ordinal mint a belső értékek! Azok szimpla adattagok!
        // Automatikus toString implementációja van amíg nem írjuk felül.
        System.out.print("Value of " + ex1 + " is ");
        ex1.printValue();
        
        // Stringből csinálhatunk enum-ot:
        String name = "THOUSAND";
        EnumExample ex2 = EnumExample.valueOf(name);
        System.out.print("Value of " + ex2 + " is ");
        ex2.printValue();
        
        // Végigiterálhatunk az összes lehetségesen:
        for (EnumExample ex : EnumExample.values()){
            System.out.println(ex);
        }
    }
    
    // felülírhatjuk a toString metódust, ekkor a super.toString() adja meg a nevet.
    @Override
    public String toString(){
        return "EnumExample."+ super.toString();
    }
}
