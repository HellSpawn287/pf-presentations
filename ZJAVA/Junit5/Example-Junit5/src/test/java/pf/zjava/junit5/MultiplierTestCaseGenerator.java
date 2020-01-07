package pf.zjava.junit5;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class MultiplierTestCaseGenerator {
  public static Stream<MultiplierTestCase> staticTestCase() {
    return Arrays.asList(
        new MultiplierTestCase(4, 2, 2),
        new MultiplierTestCase(6, 2, 3),
        new MultiplierTestCase(24, 6, 4)
    ).stream();
  }

  public static Stream<MultiplierTestCase> generatedDelayedTestCase(Integer limit, Integer delay) {
    return generatedTestCase(limit).peek((tc) -> {
      addDelay(delay);
    });
  }

  public static Stream<MultiplierTestCase> generatedTestCase() {
    return generatedTestCase(10);
  }

  public static Stream<MultiplierTestCase> generatedTestCase(Integer limit) {
    Random random = new Random();
    return Stream.generate(() -> {
      int a = random.nextInt(10) + 1;
      int b = random.nextInt(20);
      return new MultiplierTestCase(a * b, a, b);
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
