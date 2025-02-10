package worker.schedule;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map.Entry;

public class WorkerSchedule{
    private Map<Integer, HashSet<String>> weekToWorkers;

    public WorkerSchedule(){
        weekToWorkers = new HashMap<>();
    }

    public void add(int week, HashSet<String> workers){
        if (!weekToWorkers.containsKey(Integer.valueOf(week))){
            // if week was not available, create new HashSet for the week
            weekToWorkers.put(Integer.valueOf(week), new HashSet<String>(workers.size()));
        }
        HashSet<String> currentWorkers = weekToWorkers.get(Integer.valueOf(week));
        currentWorkers.addAll(workers);
        /* // equivalent:
        for (String worker : workers){
            currentWorkers.add(worker);
        }
        */
    }


    public void add(HashSet<Integer> weeks, ArrayList<String> workers){
        for (Integer week : weeks){
            add(week.intValue(), new HashSet<String>(workers));
        }
    }

    public boolean isWorkingOnWeek(String worker, int week){
        HashSet<String> workers = weekToWorkers.get(Integer.valueOf(week));
        if (null != workers){
            return workers.contains(worker);
        }else{
            return false;
        }
    }

    public HashSet<Integer> getWorkWeeks(String worker){
        HashSet<Integer> workingWeeks = new HashSet<>();
        
        for (Entry<Integer, HashSet<String>> entry : weekToWorkers.entrySet()){
            if (entry.getValue().contains(worker)){
                workingWeeks.add(entry.getKey());
            }
        }

        /* // equivalent:
        for (Integer week : weekToWorkers.keySet()){
            if (weekToWorkers.get(week).contains(worker)){
                workingWeeks.add(week);
            }
        }
        */

        return workingWeeks;
    }
}