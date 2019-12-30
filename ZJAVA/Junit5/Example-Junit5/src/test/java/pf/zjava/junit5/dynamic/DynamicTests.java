package pf.zjava.junit5.dynamic;

import io.vavr.Tuple3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import pf.zjava.junit5.Multiplicator;
import pf.zjava.junit5.TestCaseGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class DynamicTests {
  private Multiplicator multiplicator = new Multiplicator();

  @TestFactory
  List<DynamicTest> dynamicTest() {
    return Arrays.asList(
        DynamicTest.dynamicTest(
            "multiply should return 4 for 2 and 2",
            () -> {
              Assertions.assertEquals(4, multiplicator.multiply(2, 2));
            }),
        DynamicTest.dynamicTest(
            "multiply should return 6 for 2 and 3",
            () -> {
              Assertions.assertEquals(6, multiplicator.multiply(2, 3));
            })
    );
  }

  @TestFactory
  Stream<DynamicTest> dynamicTestMap() {
    return TestCaseGenerator.staticTestCase()
        .map(mapTestCaseToDynamicTest()
        );
  }

  @TestFactory
  Stream<DynamicTest> dynamicGeneratedTestMap() {
    return TestCaseGenerator.generatedDelayedTestCase(10, 1000)
        .map(mapTestCaseToDynamicTest()
        );
  }

  private Function<Tuple3<Integer, Integer, Integer>, DynamicTest> mapTestCaseToDynamicTest() {
    return testCase -> DynamicTest.dynamicTest(
        mapTestCaseToDynamicTestDisplayName(testCase),
        () -> {
          Assertions.assertEquals(testCase._1, multiplicator.multiply(testCase._2, testCase._3));
        });
  }

  private String mapTestCaseToDynamicTestDisplayName(Tuple3<Integer, Integer, Integer> testCase) {
    return "multiply should return " + testCase._1 + " for " + testCase._2 + " and " + testCase._3;
  }
}
