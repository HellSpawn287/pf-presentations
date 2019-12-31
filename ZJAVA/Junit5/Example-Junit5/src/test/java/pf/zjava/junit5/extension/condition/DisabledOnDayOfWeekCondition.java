package pf.zjava.junit5.extension.condition;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class DisabledOnDayOfWeekCondition implements ExecutionCondition {

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

    return context.getElement()
        .flatMap(el -> AnnotationSupport.findAnnotation(el, DisabledOnDayOfWeek.class))
        .map(this::checkIfNeedToBeDisabled)
        .orElse(ConditionEvaluationResult.enabled("no DisabledOnDAyOfWeek?"));

  }

  ConditionEvaluationResult checkIfNeedToBeDisabled(DisabledOnDayOfWeek disabledOnDayOfWeek) {
    DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
    boolean disabledDay = Arrays.asList(disabledOnDayOfWeek.value()).contains(dayOfWeek);
    if (disabledDay) {
      return ConditionEvaluationResult.disabled("today is disabled");
    }
    return ConditionEvaluationResult.enabled("today is enabled");
  }


}
