package pf.zjava.junit5.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertThrowsTests {
  @Test
  void assertThrows() {
    IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class, () -> {
      throw new IllegalStateException("Test 123");
    });
    Assertions.assertEquals("Test 123", illegalStateException.getMessage());
  }

  @Test
  void assertThrowsFailureType() {
    IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class, () -> {
      throw new IllegalArgumentException("Test 123");
    });
    Assertions.assertEquals("Test 123", illegalStateException.getMessage());
  }

  @Test
  void assertThrowsFailureMessage() {
    IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class, () -> {
      throw new IllegalStateException("Test 1234");
    });
    Assertions.assertEquals("Test 123", illegalStateException.getMessage());
  }

  @Test
  void assertThrowsFailureNoException() {
    IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class, () -> {
      System.out.println("No exception");
    });
    Assertions.assertEquals("Test 123", illegalStateException.getMessage());
  }
}
