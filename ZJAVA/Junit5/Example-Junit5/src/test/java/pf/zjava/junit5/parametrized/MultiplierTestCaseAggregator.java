package pf.zjava.junit5.parametrized;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import pf.zjava.junit5.MultiplierTestCase;

public class MultiplierTestCaseAggregator implements ArgumentsAggregator {
  @Override
  public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
    return new MultiplierTestCase(accessor.getInteger(0), accessor.getInteger(1), accessor.getInteger(2));
  }
}
