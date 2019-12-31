package pf.zjava.junit5.extension.condition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DayOfWeek;

public class ConditionTest {

  @Test
  @ExtendWith(DisabledWhenNormalTestCondition.class)
  void disabledWhenParametrized() {
    Assertions.fail("Should not be run");
  }
  @ParameterizedTest
  @EnumSource(value = JRE.class)
  @ExtendWith(DisabledWhenNormalTestCondition.class)
  void notDisabledWhenParametrized(JRE jre) {
    System.out.println("notDisabledWhenParametrized");
  }

  @Test
  @DisabledOnDayOfWeek(DayOfWeek.MONDAY)
  void disabledOnDayOfWeek() {
    System.out.println("disabledOnDayOfWeek run");
  }

}
