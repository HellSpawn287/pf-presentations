package pf.zjava.junit5.parametrized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pf.zjava.junit5.Multiplicator;
import pf.zjava.junit5.MultiplicatorTestCase;
import pf.zjava.junit5.MultiplicatorTestCaseGenerator;

import java.util.stream.Stream;

public class ParametrizedTestsWithMethodSourceTests {

  private Multiplicator multiplicator = new Multiplicator();
  ;

  static Stream<MultiplicatorTestCase> testCaseSource() {
    return MultiplicatorTestCaseGenerator.generatedTestCase();
  }

  static Stream<Arguments> testCaseArgumentSource() {
    return MultiplicatorTestCaseGenerator.generatedTestCase()
        .map(testCase -> Arguments.of(testCase.result, testCase.a, testCase.b));
  }

  @ParameterizedTest(name = "multiply TestCase {0}")
  @MethodSource("testCaseSource")
  void currentClassMethodSourceTest(MultiplicatorTestCase testCase) {
    Assertions.assertEquals(testCase.result, multiplicator.multiply(testCase.a, testCase.b));
  }

  @ParameterizedTest()
  @MethodSource("pf.zjava.junit5.TestCaseGenerator#generatedTestCase")
  void externalMethodSourceTest(MultiplicatorTestCase testCase) {
    Assertions.assertEquals(testCase.result, multiplicator.multiply(testCase.a, testCase.b));
  }

  @ParameterizedTest(name = "multiply should return {0} for {1} and {2}")
  @MethodSource("testCaseArgumentSource")
  void namedMethodArgumentsSourceTest(Integer result, Integer a, Integer b) {
    Assertions.assertEquals(result, multiplicator.multiply(a, b));
  }

  @ParameterizedTest
  @MethodSource("testCaseArgumentSource")
  void methodArgumentsSourceTest(Integer result, Integer a, Integer b) {
    Assertions.assertEquals(result, multiplicator.multiply(a, b));
  }
}
