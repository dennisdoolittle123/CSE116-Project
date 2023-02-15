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
        numbers.add(30.0);
        numbers.add(30.0);
        numbers.add(31.0);
        double expected = 30.3333;
        double actual = ProblemSet.average(numbers);
        assertTrue(expected - actual <= 1 && expected - actual >= -1);
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
    @Test
    public void testSumOfDigitsWithThreeDigitNumbers() {
        int num1 = 113;
        int num2 = 426;
        int expected1 = 5;
        int expected2 = 12;
        int actual1 = ProblemSet.sumOfDigits(num1);
        int actual2 = ProblemSet.sumOfDigits(num2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
    @Test
    public void testBestKeyposnegmax() {
        HashMap<String, Integer> map1 = new HashMap<>();
        String expected1 = "";
        String actual1 = ProblemSet.bestKey(map1);
        assertEquals(expected1, actual1);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 2);
        String expected2 = "b";
        String actual2 = ProblemSet.bestKey(map2);
        assertTrue(expected2.equals(actual2) || "c".equals(actual2));

        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("a", -1);
        map3.put("b", -2);
        map3.put("c", -3);
        String expected3 = "a";
        String actual3 = ProblemSet.bestKey(map3);
        assertTrue(expected3.equals(actual3));
    }

    @Test
    public void testAverageWithNegativeNumbers() {
        ArrayList<Double> numbers = new ArrayList<Double>();
        numbers.add(4.0);
        numbers.add(4.0);
        numbers.add(-2.0);
        double expected = 2.0;
        double actual = ProblemSet.average(numbers);
        assertEquals(expected, actual, 0.001);
    }
    @Test
    public void testAverageLargeList() {
        ArrayList<Double> numbers = new ArrayList<Double>();
        for (int i = 0; i < 1000000; i++) {
            numbers.add((double)i);
        }
        double expected = 499999.5;
        double actual = ProblemSet.average(numbers);
        assertEquals(expected, actual, 0.001);
    }




    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class



}