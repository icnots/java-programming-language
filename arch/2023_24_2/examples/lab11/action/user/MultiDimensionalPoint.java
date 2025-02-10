package action.user;

import action.Scalable;
import action.Undoable;

import java.util.Objects;
import java.util.Arrays;

public class MultiDimensionalPoint
    implements Scalable, Undoable, Comparable<MultiDimensionalPoint>
{
    private int[] coordinates;
    private int[] lastCoordinates;

    public MultiDimensionalPoint(int... params){
        coordinates = new int[params.length];

        System.arraycopy(params, 0, coordinates, 0, params.length);
        // or equivalently:
        /*
        for (int i = 0; i < params.length; i++){
            coordinates[i] = params[i];
        }
        */

        lastCoordinates = new int[params.length];
        System.arraycopy(params, 0, lastCoordinates, 0, params.length);
    }

    public int get(int index){
        return coordinates[index];
    }

    public void set(int index, int value){
        saveToLast();

        coordinates[index] = value;
    }

    @Override
    public void scale(int p){
        saveToLast();

        for (int i = 0; i < coordinates.length; i++){
            coordinates[i] *= p;
        }
    }

    private void saveToLast(){
        lastCoordinates = new int[coordinates.length];
        System.arraycopy(coordinates, 0, lastCoordinates, 0, coordinates.length);
    }

    @Override
    public void undoLast(){
        int[] temp = coordinates;
        coordinates = lastCoordinates;
        lastCoordinates = temp;
    }

    @Override
    public int hashCode(){
        return Objects.hash(coordinates);
    }

    @Override
    public boolean equals(Object that){
        if (this == that) {
            return true;
        } else if (that instanceof MultiDimensionalPoint){
            MultiDimensionalPoint mdp = (MultiDimensionalPoint)that;
            return Arrays.equals(this.coordinates, mdp.coordinates);
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int elem : coordinates){
            sb.append(elem);
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(MultiDimensionalPoint that){
        int dimensionDiff = this.coordinates.length - that.coordinates.length;
        if (dimensionDiff != 0){
            return dimensionDiff;
        }

        for (int i = 0; i < coordinates.length; i++){
            int coordinateDiff = this.coordinates[i] - that.coordinates[i];
            if (coordinateDiff != 0){
                return coordinateDiff;
            }
        }

        return 0;
    }
}