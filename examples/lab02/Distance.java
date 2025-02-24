public class Distance {
    public static void main(String[] args){
        Point last = null; // olyan mint egy nullpointer
        if (0 != args.length % 2){
            System.err.println("Please, provide even number of arguments!");
            return;
        }
        
        double dist = 0.;
        for (int i = 0; i < args.length; i += 2){
            Point next = new Point(
                Double.parseDouble(args[i]),
                Double.parseDouble(args[i+1])
            );
            if (null != last){
                dist += last.distance(next);
            }
            last = next;
        }
        
        System.out.println(dist);
    }

}
