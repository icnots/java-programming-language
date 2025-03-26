package race.car;

public class WrongSectorTimer2{
    private int[] sectorTimes;

    public WrongSectorTimer2(int[] sectorTimes){
        this.sectorTimes = sectorTimes;
    }

    public int[] getSectorTimes(){
        return sectorTimes;
    }

    public void setSectorTimes(int[] sectorTimes){
        this.sectorTimes = sectorTimes;
    }

    public int getLapTime(int n){
        return 0;
    }
    public int getSectorTime(int n){
        return 0;
    }
}