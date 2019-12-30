package pf.zjava.junit5.parametrized;

import io.vavr.Tuple3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pf.zjava.junit5.Multiplicator;
import pf.zjava.junit5.TestCaseGenerator;

import java.util.stream.Stream;

public class ParametrizedTestsWithMethodSourceTests {

  private Multiplicator multiplicator = new Multiplicator();
  ;

  static Stream<Tuple3<Integer, Integer, Integer>> testCaseSource() {
    return TestCaseGenerator.generatedTestCase();
  }

  static Stream<Arguments> testCaseArgumentSource() {
    return TestCaseGenerator.generatedTestCase()
        .map(testCase -> Arguments.of(testCase._1, testCase._2, testCase._3));
  }

  @ParameterizedTest(name = "multiply TestCase {0}")
  @MethodSource("testCaseSource")
  void currentClassMethodSourceTest(Tuple3<Integer, Integer, Integer> testCase) {
    Assertions.assertEquals(testCase._1, multiplicator.multiply(testCase._2, testCase._3));
  }

  @ParameterizedTest()
  @MethodSource("pf.zjava.junit5.TestCaseGenerator#generatedTestCase")
  void externalMethodSourceTest(Tuple3<Integer, Integer, Integer> testCase) {
    Assertions.assertEquals(testCase._1, multiplicator.multiply(testCase._2, testCase._3));
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
