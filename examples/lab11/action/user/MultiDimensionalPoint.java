package action.user;

import java.util.Arrays;
import java.util.Objects;

public class MultiDimensionalPoint implements action.Undoable, action.Scalable, Comparable<MultiDimensionalPoint>{
    private int[] coordinates;
    private int[] lastCoordinates;

    public MultiDimensionalPoint(int... coordinates){
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
        this.lastCoordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    public int get(int idx){
        if (0 <= idx && idx < coordinates.length){
            return coordinates[idx];
        }else{
            String msg = "MultiDimensionalPoint get function called with illegal index " + idx;
            System.err.println(msg);
            throw new IllegalArgumentException(msg);
        }
    }

    public void set(int idx, int value){
        saveToLast();

        if (0 <= idx && idx < coordinates.length){
            this.coordinates[idx] = value;
        }else{
            String msg = "MultiDimensionalPoint set function called with illegal index " + idx;
            System.err.println(msg);
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public void scale(int factor){
        saveToLast();

        for (int i = 0; i < this.coordinates.length; i++){
            coordinates[i] *= factor;
        }
    }

    private void saveToLast(){
        // this.lastCoordinates = Arrays.copyOf(this.coordinates, this.coordinates.length);

        // The above line is equivalent with the following:
        this.lastCoordinates = new int[this.coordinates.length];
        for (int i = 0; i < this.coordinates.length; i++){
            this.lastCoordinates[i] = this.coordinates[i];
        }
    }

    @Override
    public void undoLast(){
        int[] atm = this.lastCoordinates;
        this.lastCoordinates = this.coordinates;
        this.coordinates = atm;
    }

    @Override
    public boolean equals(Object obj){
        if (this.getClass().equals(obj.getClass())){
            MultiDimensionalPoint that = (MultiDimensionalPoint)obj;

            return Arrays.equals(this.coordinates, that.coordinates);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.coordinates);
    }

    @Override
    public int compareTo(MultiDimensionalPoint that){
        int dimensionDiff = this.coordinates.length - that.coordinates.length;
        if (dimensionDiff == 0){
            for (int i = 0; i < coordinates.length; i++){
                int diff = this.coordinates[i] - that.coordinates[i];
                if (diff != 0){
                    return diff;
                }
            }
            return 0;

            // or equivalently:
            //return Arrays.compare(this.coordinates, that.coordinates);
        }else{
            return this.coordinates.length - that.coordinates.length;
        }
    }

}