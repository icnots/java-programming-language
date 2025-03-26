package race.car;

public class SectorTimer{
    private int[] sectorTimes;

    private void initSectorTimes(int[] sectorTimes){
        this.sectorTimes = sectorTimes.clone();
    }

    public SectorTimer(int... sectorTimes){
        initSectorTimes(sectorTimes);
    }

    public SectorTimer(boolean val, int... sectorTimes){
        int len = sectorTimes.length;
        this.sectorTimes = new int[len];
        System.arraycopy(sectorTimes, 0, this.sectorTimes, 0, len);
    }

    public int[] getSectorTimes(){
        return sectorTimes.clone();
    }
    public int[] getSectorTimesV2(){
        int len = sectorTimes.length;
        int[] ret = new int[len];
        System.arraycopy(sectorTimes, 0, ret, 0, len);
        return ret;
    }
    

    public void setSectorTimes(int... sectorTimes){
        initSectorTimes(sectorTimes);
    }
    
    public void setSectorTimesV2(int... sectorTimes){
        int len = sectorTimes.length;
        this.sectorTimes = new int[len];
        System.arraycopy(sectorTimes, 0, this.sectorTimes, 0, len);
    }
    

    public int getLapTime(int n){
        // intentionally nothing
        return 0;
    }
    public int getSectorTime(int n){
        // intentionally nothing
        return 0;
    }

    public void setLapTimes(int[] a){
        // intentionally nothing
    }
}