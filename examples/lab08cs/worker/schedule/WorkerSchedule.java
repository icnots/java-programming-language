package worker.schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;

public class WorkerSchedule{
    private HashMap<Integer, HashSet<String> > weekToWorkers;

    public WorkerSchedule(){
        weekToWorkers = new HashMap<>();
    }

    public void add(int week, HashSet<String> workers){
        // same as weekToWorkers.containsKey(week)
        if (!weekToWorkers.containsKey(Integer.valueOf(week))){
            weekToWorkers.put(Integer.valueOf(week), new HashSet<String>());
        }

        HashSet<String> currentWorker = weekToWorkers.get(Integer.valueOf(week));

        currentWorker.addAll(workers);
    }
    
    public void add(HashSet<Integer> weeks, ArrayList<String> workers){
        HashSet<String> workersAsHashSet = new HashSet<>(workers);
        for (Integer week : weeks){
            add(week.intValue(), workersAsHashSet);
        }
    }

    public boolean isWorkingOnWeek(String worker, int week){
        HashSet<String> currentWorker = weekToWorkers.get(Integer.valueOf(week));

        if (null == currentWorker){
            return false;
        }else{
            return currentWorker.contains(worker);
        }
    }

    public HashSet<Integer> getWorkWeeks(String name){
        HashSet<Integer> weeks = new HashSet<>();

        for (Map.Entry<Integer, HashSet<String> > entry : weekToWorkers.entrySet()){
            if (entry.getValue().contains(name)){
                weeks.add(entry.getKey());
            }
        }

        return weeks;
    }
}