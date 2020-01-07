package pf.zjava.junit5.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import pf.zjava.junit5.Multiplier;
import pf.zjava.junit5.MultiplierTestCase;
import pf.zjava.junit5.MultiplierTestCaseGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class DynamicTests {
  private Multiplier multiplier = new Multiplier();

  @TestFactory
  List<DynamicTest> dynamicTest() {
    return Arrays.asList(
        DynamicTest.dynamicTest(
            "multiply should return 4 for 2 and 2",
            () -> {
              Assertions.assertEquals(4, multiplier.multiply(2, 2));
            }),
        DynamicTest.dynamicTest(
            "multiply should return 6 for 2 and 3",
            () -> {
              Assertions.assertEquals(6, multiplier.multiply(2, 3));
            })
    );
  }

  @TestFactory
  Stream<DynamicTest> dynamicTestMap() {
    return MultiplierTestCaseGenerator.staticTestCase()
        .map(mapTestCaseToDynamicTest()
        );
  }

  @TestFactory
  Stream<DynamicTest> dynamicGeneratedTestMap() {
    return MultiplierTestCaseGenerator.generatedDelayedTestCase(10, 1000)
        .map(mapTestCaseToDynamicTest()
        );
  }

  private Function<MultiplierTestCase, DynamicTest> mapTestCaseToDynamicTest() {
    return testCase -> DynamicTest.dynamicTest(
        mapTestCaseToDynamicTestDisplayName(testCase),
        () -> {
          Assertions.assertEquals(testCase.result, multiplier.multiply(testCase.a, testCase.b));
        });
  }

  private String mapTestCaseToDynamicTestDisplayName(MultiplierTestCase testCase) {
    return "multiply should return " + testCase.result + " for " + testCase.a + " and " + testCase.b;
  }
}
