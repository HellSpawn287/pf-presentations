package pf.zjava.junit5.parametrized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pf.zjava.junit5.Multiplier;
import pf.zjava.junit5.MultiplierTestCase;
import pf.zjava.junit5.MultiplierTestCaseGenerator;

import java.util.stream.Stream;

public class ParametrizedTestsWithMethodSourceTests {

  private Multiplier multiplier = new Multiplier();
  ;

  static Stream<MultiplierTestCase> testCaseSource() {
    return MultiplierTestCaseGenerator.generatedTestCase();
  }

  static Stream<Arguments> testCaseArgumentSource() {
    return MultiplierTestCaseGenerator.generatedTestCase()
        .map(testCase -> Arguments.of(testCase.result, testCase.a, testCase.b));
  }

  @ParameterizedTest(name = "multiply TestCase {0}")
  @MethodSource("testCaseSource")
  void currentClassMethodSourceTest(MultiplierTestCase testCase) {
    Assertions.assertEquals(testCase.result, multiplier.multiply(testCase.a, testCase.b));
  }

  @ParameterizedTest()
  @MethodSource("pf.zjava.junit5.TestCaseGenerator#generatedTestCase")
  void externalMethodSourceTest(MultiplierTestCase testCase) {
    Assertions.assertEquals(testCase.result, multiplier.multiply(testCase.a, testCase.b));
  }

  @ParameterizedTest(name = "multiply should return {0} for {1} and {2}")
  @MethodSource("testCaseArgumentSource")
  void namedMethodArgumentsSourceTest(Integer result, Integer a, Integer b) {
    Assertions.assertEquals(result, multiplier.multiply(a, b));
  }

  @ParameterizedTest
  @MethodSource("testCaseArgumentSource")
  void methodArgumentsSourceTest(Integer result, Integer a, Integer b) {
    Assertions.assertEquals(result, multiplier.multiply(a, b));
  }
}
