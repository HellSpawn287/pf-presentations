package pf.zjava.junit5.parametrized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParametrizedTestsWithSimpleSourceTests {

  @ParameterizedTest(name = "Test no. {index} - {0} should be even")
  @ValueSource(ints = { 2, 4, 6, 7})
  void namedValueSourceTest(int param){
    Assertions.assertTrue(param % 2 == 0, "should be not even");
  }

  @ParameterizedTest
  @ValueSource(ints = { 2, 4, 6, 7})
  void valueSourceTest(int param){
    Assertions.assertTrue(param % 2 == 0, "should be not even");
  }

  @ParameterizedTest(name = "{0} should be current version")
  @EnumSource(value = JRE.class, names = "JAVA_11")
  void enumSourceInclude(JRE version){
    Assertions.assertTrue(version.isCurrentVersion(), version + "should be current version");
  }

  @ParameterizedTest(name = "{0} should not be current version")
  @EnumSource(value = JRE.class, names = "JAVA_11", mode = EnumSource.Mode.EXCLUDE)
  void enumSourceExclude(JRE version){
    Assertions.assertFalse(version.isCurrentVersion(), version + "should not be current version");
  }
}
