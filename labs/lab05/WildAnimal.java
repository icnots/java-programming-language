enum WildAnimal{
    MONKEY("banana", 10);
    
    String food;
    int amount;
    
    WildAnimal(String food, int amount){
        this.food = food;
        this.amount = amount;
    }
    
    static String listAnimals(){
        StringBuilder sb = new StringBuilder();
        
        for (WildAnimal wa : WildAnimal.values()){
            sb.append( wa.ordinal() );
            sb.append(": ").append(food*7).append(" eats.");
            
        
        }
    
        return sb.toString();
    
    }


}
