package race.car;

public class WrongSectorTimer2{
    private int[] sectorTimes;

    public int[] getSectorTimes(){
        return sectorTimes;
    }

    public void setSectorTimes(int[] sectorTimes){
        this.sectorTimes = sectorTimes;
    }

    public WrongSectorTimer2(int[] sectorTimes){
        this.sectorTimes = sectorTimes;
    }

    public int getLapTime(int lap){
        return sectorTimes[lap];
    }

    public int getSectorTime(int index){
        return sectorTimes[index];
    }
}