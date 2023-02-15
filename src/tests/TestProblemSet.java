package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TestProblemSet {
    private final double EPSILON = 0.001;
    public void compareDoubles(double d1, double d2){
        assertTrue(Math.abs(d1-d2)<EPSILON);
    }
    @Test
    public void testaverage(){
        ArrayList<Double> numbers = new ArrayList<Double>();
        numbers.add(30.0);
        numbers.add(30.0);
        numbers.add(30.0);
        double expected = 30.0;
        double actualans = ProblemSet.average(numbers);
        assertEquals(expected, actualans,0.001);

    }
    @Test
    public void testaveragesingleton(){
        ArrayList<Double> numbers = new ArrayList<Double>();
        numbers.add(30.0);
        double expected = 30.0;
        double actualans = ProblemSet.average(numbers);
        assertEquals(expected, actualans,0.001);

    }
    @Test
    public void testAverageOffByOne() {
        ArrayList<Double> numbers = new ArrayList<Double>();
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        double expected = 2.0;
        double actual = ProblemSet.average(numbers);
        assertTrue(expected == actual || expected == actual + 1 || expected == actual - 1);
    }


    @Test
    public void testsumOfdigits(){
        int s = 132;
        int expected = 6;
        int actual = ProblemSet.sumOfDigits(s);
        assertEquals(expected, actual);
    }
    @Test
    public void extratestsumofdigits(){
        int a = 0;
        int expected = 0;
        int actual = ProblemSet.sumOfDigits(a);
        assertEquals(expected,actual);
    }

    @Test
    public void testBestKey() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        String expected = "three";
        String actual = ProblemSet.bestKey(map);
        assertEquals(expected, actual);
    }
    @Test
    public void testbestkey2() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 0);
        map.put("two", 0);
        map.put("four", 4);
        String expected = "four";
        String actual = ProblemSet.bestKey(map);
        assertEquals(expected, actual);
    }




    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class



}