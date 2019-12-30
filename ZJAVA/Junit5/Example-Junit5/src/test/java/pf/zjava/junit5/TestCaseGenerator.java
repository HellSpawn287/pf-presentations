package pf.zjava.junit5;

import io.vavr.Tuple3;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class TestCaseGenerator {
  public static Stream<Tuple3<Integer, Integer, Integer>> staticTestCase() {
    return Arrays.asList(
        new Tuple3<>(4, 2, 2),
        new Tuple3<>(6, 2, 3),
        new Tuple3<>(24, 6, 4)
    ).stream();
  }

  public static Stream<Tuple3<Integer, Integer, Integer>> generatedDelayedTestCase(Integer limit, Integer delay) {
    return generatedTestCase(limit).peek((tc)-> {
      addDelay(delay);
    });
  }
  public static Stream<Tuple3<Integer, Integer, Integer>> generatedTestCase(){
    return generatedTestCase(10);
  }
  public static Stream<Tuple3<Integer, Integer, Integer>> generatedTestCase(Integer limit) {
    Random random = new Random();
    return Stream.generate(() -> {
      int a = random.nextInt(10)+1;
      int b = random.nextInt(20);
      return new Tuple3<>(a*b, a, b);
    }).limit(limit);
  }
  private static void addDelay(Integer delay) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
