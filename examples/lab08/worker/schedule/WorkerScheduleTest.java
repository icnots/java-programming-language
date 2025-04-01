package worker.schedule;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import java.util.HashSet;

public class WorkerScheduleTest {
    @Test
    public void testEmpty(){
        WorkerSchedule ws = new WorkerSchedule();

        assertFalse(ws.isWorkingOnWeek("Sanyi", 12));
        assertFalse(ws.isWorkingOnWeek("Ferike", 0));

    }
    
    @Test
    public void testWorker(){
        WorkerSchedule ws = new WorkerSchedule();

        HashSet<String> workers = new HashSet<>();
        workers.add("Sanyi");
        ws.add(12, workers);
        
        
        assertTrue(ws.isWorkingOnWeek("Sanyi", 12));
        HashSet<Integer> expectedWeeks = new HashSet<Integer>();
        expectedWeeks.add(12);

        assertEquals(expectedWeeks, ws.getWorkWeeks("Sanyi"));

    }

}
