package race.car;


public class SectorTimer{
    private int[] sectorTimes;

    public int[] getSectorTimes(){
        return sectorTimes.clone();
    }

    public SectorTimer(int... sectorTimes){
        initSectorTimes(sectorTimes);
    }

    public SectorTimer(boolean bool, int... sectorTimes){
        initSectorTimes(sectorTimes);
    }

    public int getSectorTime(int index){
        return sectorTimes[index];
    }

    public int[] getSectorTimesV2(){
        int[] returningArray = new int[sectorTimes.length];
        
        System.arraycopy(sectorTimes, 0, returningArray, 0, sectorTimes.length);

        return returningArray;
    }

    private void initSectorTimes(int[] sectorTimes){
        this.sectorTimes = java.util.Arrays.copyOf(sectorTimes, sectorTimes.length);
    }

    public void setLapTimes(int... lapTimes){
        initSectorTimes(lapTimes);
    }

    public void setSectorTimesV2(int... lapTimes){
        initSectorTimes(lapTimes);
    }
}
