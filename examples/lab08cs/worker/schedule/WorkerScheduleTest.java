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
import java.util.List;
import java.util.ArrayList;

public class WorkerScheduleTest{
    @Test
    public void emptySchedule(){
        WorkerSchedule ws = new WorkerSchedule();

        assertFalse(ws.isWorkingOnWeek("Sanyi", 13));
        assertFalse(ws.isWorkingOnWeek("Sanyi", 0));
        assertFalse(ws.isWorkingOnWeek("Nóri", 100));
    }

    @Test
    public void scheduleWithSampleAdd(){
        WorkerSchedule ws = new WorkerSchedule();

        HashSet<String> workers = new HashSet<>(List.of("name1", "name2", "name3"));
        ws.add(2, workers);
        ws.add(3, workers);
        ws.add(4, workers);

        for (int i = 2; i <= 4; i++){
            assertTrue(ws.isWorkingOnWeek("name1", i));
            assertTrue(ws.isWorkingOnWeek("name2", i));
            assertTrue(ws.isWorkingOnWeek("name3", i));
        }
        for (int i = 5; i <= 8; i++){
            assertFalse(ws.isWorkingOnWeek("name1", i));
            assertFalse(ws.isWorkingOnWeek("name2", i));
            assertFalse(ws.isWorkingOnWeek("name3", i));
        }
        for (int i = 0; i <= 1; i++){
            assertFalse(ws.isWorkingOnWeek("name1", i));
            assertFalse(ws.isWorkingOnWeek("name2", i));
            assertFalse(ws.isWorkingOnWeek("name3", i));
        }

        HashSet<Integer> expectedWeeks = new HashSet<>(List.of(2, 3, 4));
        assertEquals(expectedWeeks, ws.getWorkWeeks("name1"));
        assertEquals(expectedWeeks, ws.getWorkWeeks("name2"));
        assertEquals(expectedWeeks, ws.getWorkWeeks("name3"));
    }

    @Test
    public void scheduleWithComplexAdd(){
        WorkerSchedule ws = new WorkerSchedule();

        ArrayList<String> workers = new ArrayList<>(List.of("name1", "name2", "name3"));
        HashSet<Integer> weeks = new HashSet<>(List.of(2, 3, 4));

        ws.add(weeks, workers);

        for (int i = 2; i <= 4; i++){
            assertTrue(ws.isWorkingOnWeek("name1", i));
            assertTrue(ws.isWorkingOnWeek("name2", i));
            assertTrue(ws.isWorkingOnWeek("name3", i));
        }
        for (int i = 5; i <= 8; i++){
            assertFalse(ws.isWorkingOnWeek("name1", i));
            assertFalse(ws.isWorkingOnWeek("name2", i));
            assertFalse(ws.isWorkingOnWeek("name3", i));
        }
        for (int i = 0; i <= 1; i++){
            assertFalse(ws.isWorkingOnWeek("name1", i));
            assertFalse(ws.isWorkingOnWeek("name2", i));
            assertFalse(ws.isWorkingOnWeek("name3", i));
        }

        HashSet<Integer> expectedWeeks = new HashSet<>(List.of(2, 3, 4));
        assertEquals(expectedWeeks, ws.getWorkWeeks("name1"));
        assertEquals(expectedWeeks, ws.getWorkWeeks("name2"));
        assertEquals(expectedWeeks, ws.getWorkWeeks("name3"));
    }

    @ParameterizedTest(name = "ws with {0} working on weeks {1}")
    @CsvSource(textBlock = """
        'name1,name2,name3,name4', '1,3,5,7'
        'Feri,Otto', '0,1,2,3,4,5,6,7,8,9,10'
    """)
    @DisableIfHasBadStructure
    public void testParameterized(String workerNames, String weeksAsString){
        WorkerSchedule ws = new WorkerSchedule();

        ArrayList<String> workers = new ArrayList<>(List.of(workerNames.split(",")));
        HashSet<Integer> weeks = new HashSet<>();
        for (String weekAsString : weeksAsString.split(",")){
            weeks.add(Integer.parseInt(weekAsString));
        }

        ws.add(weeks, workers);

        for (Integer week : weeks){
            for (String name : workers){
                assertTrue(ws.isWorkingOnWeek(name, week.intValue()));
            }
        }
    }
}
