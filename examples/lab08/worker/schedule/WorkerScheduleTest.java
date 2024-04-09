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
import java.util.ArrayList;
import java.util.Arrays;

public class WorkerScheduleTest{
    @Test
    public void testWorkerSchedule(){
        WorkerSchedule ws = new WorkerSchedule();

        ws.add(5, new HashSet<String>(Arrays.asList("James")));

        assertTrue(ws.isWorkingOnWeek("James", 5));
        assertFalse(ws.isWorkingOnWeek("James", 3));
        assertFalse(ws.isWorkingOnWeek("Sam", 5));
    }

    @ParameterizedTest(name = "{0} does not work on week {1} if nothing scheduled.")
    @CsvSource(textBlock = """
        Feri, 1
        Lajos, 3
    """)
    public void emptySchedule(String name, int week){
        WorkerSchedule ws = new WorkerSchedule();

        assertFalse(ws.isWorkingOnWeek(name, week));
    }

    @ParameterizedTest(name = "Checking specific persons on specific weeks ({0})")
    @CsvSource(textBlock = """
        Jack, true, true, true
        James, true, true, false
        Sam, false, true, true
        Jill, true, false, true
        Tom, true, false, false
        Harry, false, true, false
        Will, false, false, true
        Rick, false, false, false
    """)
    public void schedule(String name, boolean week1, boolean week2, boolean week3){
        WorkerSchedule ws = new WorkerSchedule();

        String[] workersOnWeek1 = new String[]{"Jack", "James", "Jill", "Tom"};
        String[] workersOnWeek2 = new String[]{"Jack", "James", "Sam", "Harry"};
        String[] workersOnWeek3 = new String[]{"Jack", "Sam", "Jill", "Will"};

        for (String worker : workersOnWeek1){
            ws.add(1, new HashSet<String>(Arrays.asList(worker)));
        }

        ws.add(new HashSet<Integer>(Arrays.asList(2)), new ArrayList<String>(Arrays.asList(workersOnWeek2)));
        ws.add(new HashSet<Integer>(Arrays.asList(3)), new ArrayList<String>(Arrays.asList(workersOnWeek3)));

        assertEquals(week1, ws.getWorkWeeks(name).contains(Integer.valueOf(1)));
    }
}