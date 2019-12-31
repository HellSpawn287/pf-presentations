package pf.zjava.junit5.extension.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

public class DisabledWhenNormalTestCondition implements ExecutionCondition {
  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    Boolean parameterizedTest = isNormalTest(context);
    if (parameterizedTest) {
      return ConditionEvaluationResult.disabled("This test can't be normal");
    }
    return ConditionEvaluationResult.enabled("This test is not normal");
  }

  private Boolean isNormalTest(ExtensionContext context) {
    return context.getElement()
        .map(el -> AnnotationSupport.isAnnotated(el, Test.class))
        .orElse(false);
  }
}
