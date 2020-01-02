package pf.zjava.junit5;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class MultiplicatorTestCaseGenerator {
  public static Stream<MultiplicatorTestCase> staticTestCase() {
    return Arrays.asList(
        new MultiplicatorTestCase(4, 2, 2),
        new MultiplicatorTestCase(6, 2, 3),
        new MultiplicatorTestCase(24, 6, 4)
    ).stream();
  }

  public static Stream<MultiplicatorTestCase> generatedDelayedTestCase(Integer limit, Integer delay) {
    return generatedTestCase(limit).peek((tc) -> {
      addDelay(delay);
    });
  }

  public static Stream<MultiplicatorTestCase> generatedTestCase() {
    return generatedTestCase(10);
  }

  public static Stream<MultiplicatorTestCase> generatedTestCase(Integer limit) {
    Random random = new Random();
    return Stream.generate(() -> {
      int a = random.nextInt(10) + 1;
      int b = random.nextInt(20);
      return new MultiplicatorTestCase(a * b, a, b);
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
