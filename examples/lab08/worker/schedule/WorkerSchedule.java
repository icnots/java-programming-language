package worker.schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;

public class WorkerSchedule{
    private HashMap<Integer, HashSet<String>> weekToWorkers;

    public WorkerSchedule(){
        weekToWorkers = new HashMap<>();
    }

    public void add(int week, HashSet<String> workers){
        HashSet<String> currentWorkers = weekToWorkers.get(Integer.valueOf(week));
        // HashSet<String> currentWorkers = weekToWorkers.get(week);

        if (null == currentWorkers){
            weekToWorkers.put(week, new HashSet<String>(workers));
        }else{
            for (String name : workers){
                currentWorkers.add(name);
            }
        }
    }

    public void add(HashSet<Integer> weeks, ArrayList<String> workers){
        HashSet<String> workersAsHashSet = new HashSet<>(workers);
        for (Integer week : weeks){
            add(week, workersAsHashSet);
        }
    }

    public boolean isWorkingOnWeek(String name, int week){
        HashSet<String> currentWorkers = weekToWorkers.get(Integer.valueOf(week));

        if (null == currentWorkers){
            return false;
        }else{
            return currentWorkers.contains(name);
        }
    }

    public HashSet<Integer> getWorkWeeks(String name){
        HashSet<Integer> workingWeeks = new HashSet<>();

        for (Map.Entry<Integer, HashSet<String>> entry : weekToWorkers.entrySet()){
            if (entry.getValue().contains(name)){
                workingWeeks.add(entry.getKey());
            }
        }

        return workingWeeks;
    }
}