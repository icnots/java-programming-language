package data.structure;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ListUtilTest {
    @ParameterizedTest(name = "divisors({0})")
    @CsvSource(textBlock = """
        0, ''
        1, '1'
        64, '1,2,4,8,16,32,64'
        360, '1,2,3,4,5,6,8,9,10,12,15,18,20,24,30,36,40,45,60,72,90,120,180,360'
    """)
    @DisableIfHasBadStructure
    public void testDivisors(int n, String divisors){
        ArrayList<Integer> expected;
        if (divisors.length() == 0){
            expected = new ArrayList<Integer>();
        }else{
            String[] numbersAsText = divisors.split(",");
            expected = new ArrayList<Integer>(numbersAsText.length);
            for (int i = 0; i < numbersAsText.length; i++){
                expected.add(Integer.parseInt(numbersAsText[i]));
            }
        }

        assertEquals(expected, ListUtil.divisors(n));
    }
    
    @Test
    public void testWithSameStartEnd(){
        ArrayList<String> texts = new ArrayList<>();
        ArrayList<String> expected = new ArrayList<>();

        assertEquals(expected, ListUtil.withSameStartEnd(texts));


        // üres szöveg (a kimenet nem változik meg)
        texts.add("");
        assertEquals(expected, ListUtil.withSameStartEnd(texts));
        
        // null (a kimenet nem változik meg)
        texts.add(null);
        assertEquals(expected, ListUtil.withSameStartEnd(texts));

        // egyetlen szóközt tartozó szöveg (belekerül a kimenetbe)
        texts.add(" ");
        expected.add(" ");
        assertEquals(expected, ListUtil.withSameStartEnd(texts));

        // az x szöveg (belekerül a kimenetbe)
        texts.add("x");
        expected.add("x");
        assertEquals(expected, ListUtil.withSameStartEnd(texts));

        // üres szöveg (a kimenet nem változik meg)
        texts.add("");
        assertEquals(expected, ListUtil.withSameStartEnd(texts));
        
        // a different start and end? szöveg (a kimenet nem változik meg)
        texts.add("different start and end?");
        assertEquals(expected, ListUtil.withSameStartEnd(texts));
        
        // az ends and starts the same szöveg (belekerül a kimenetbe)
        texts.add("ends and starts the same");
        expected.add("ends and starts the same");
        assertEquals(expected, ListUtil.withSameStartEnd(texts));
    }

    @Test
    public void testMaxToFront0(){
        ArrayList<String> list = null;
        ListUtil.maxToFront(list);

        list = new ArrayList<>();
        ListUtil.maxToFront(list);
    }

    @ParameterizedTest(name = "maxToFront([{0}]) => [{1}]")
    @CsvSource(textBlock = """
        'valami', 'valami'
        'can,you,succeed', 'you,can,succeed'
        '-123,2000,100', '2000,-123,100'
    """)
    @DisableIfHasBadStructure
    public void testMaxToFront(String input, String expectedTexts){
        ArrayList<String> texts = new ArrayList<>(Arrays.asList(input.split(",")));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(expectedTexts.split(",")));
        
        ListUtil.maxToFront(texts);
        assertEquals(expected, texts);
    }
}
