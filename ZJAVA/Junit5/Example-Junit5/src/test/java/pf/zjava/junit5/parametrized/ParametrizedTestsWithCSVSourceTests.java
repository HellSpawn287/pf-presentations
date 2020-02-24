package pf.zjava.junit5.parametrized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.CsvSource;
import pf.zjava.junit5.Multiplier;
import pf.zjava.junit5.MultiplierTestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ParametrizedTestsWithCSVSourceTests {

  private Multiplier multiplier = new Multiplier();

  @ParameterizedTest
  @CsvSource(value = {"4,2,2", "6,2,3", "8,4,2"})
  void csvSourceSeparateParams(Integer result, Integer a, Integer b) {
    Assertions.assertEquals(result, multiplier.multiply(a, b));
  }

  @ParameterizedTest(name = "multiply should return {0} for {1} and {2}")
  @CsvSource(value = {"4,2,2", "6,2,3", "8,4,2"})
  void namedCsvSourceSeparateParams(Integer result, Integer a, Integer b) {
    Assertions.assertEquals(result, multiplier.multiply(a, b));
  }

  @ParameterizedTest
  @CsvSource(value = {"4,2,2", "6,2,3", "8,4,2"})
  void csvSourceArgumentsAccessor(Integer result, ArgumentsAccessor arguments) {
    Assertions.assertEquals(result, multiplier.multiply(arguments.getInteger(1), arguments.getInteger(2)));
  }

  @ParameterizedTest
  @CsvSource(value = {"4,2,2,3,4,5", "6,2,3,2,3", "8,4,2,4,56"})
  void csvSourceLongerSeparateParams(Integer result, Integer a, Integer b) {
    Assertions.assertEquals(result, multiplier.multiply(a, b));
  }

  @ParameterizedTest(name = "{0}.currentVersion() is {1}")
  @CsvSource(value = {"JAVA_8, false", "JAVA_11, true"})
  void enumTest(JRE jre, boolean currentVersion) {
    Assertions.assertEquals(currentVersion, jre.isCurrentVersion());
  }

  @ParameterizedTest
  @CsvSource(value = {"2020-01-01T12:00:00, 2020-01-01 "})
  void csvDateTest(LocalDateTime ldt,
                   @JavaTimeConversionPattern("yyyy-MM-dd") LocalDate dt) {
    System.out.println(ldt.toString());
    System.out.println(dt.toString());
  }

  @ParameterizedTest(name = "multiply TestCase {0}")
  @CsvSource(value = {"4/2/2", "6/2/3", "8/4/2"})
  void csvTestCase(MultiplierTestCase testCase) {
    Assertions.assertEquals(testCase.result, multiplier.multiply(testCase.a, testCase.b));
  }

  @ParameterizedTest(name = "multiply TestCase with aggregator should return {0} for {1} and {2}")
  @CsvSource(value = {"4,2,2", "6,2,3", "8,4,2"})
  void csvTestCaseAggregator(@AggregateWith(MultiplierTestCaseAggregator.class) MultiplierTestCase testCase) {
    Assertions.assertEquals(testCase.result, multiplier.multiply(testCase.a, testCase.b));
  }

}
