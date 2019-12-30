package pf.zjava.junit5.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertAll {
  @Test
  void assertAll() {
    Assertions.assertAll(
        () -> Assertions.assertTrue(true),
        () -> Assertions.assertTrue(true, "should Be true"),
        () -> Assertions.assertTrue(true, () -> "should Be true supplied")
    );
  }
  @Test
  void assertAllFailure() {
    Assertions.assertAll(
        () -> Assertions.assertTrue(false),
        () -> Assertions.assertTrue(false, "should Be true"),
        () -> Assertions.assertTrue(false, () -> "should Be true supplied")
    );
  }
}
