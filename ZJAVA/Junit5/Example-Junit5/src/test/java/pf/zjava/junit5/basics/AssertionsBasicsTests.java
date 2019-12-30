package pf.zjava.junit5.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssertionsBasicsTests {
  @Test
  void simple() {
    Assertions.assertTrue(true);
    Assertions.assertTrue(true, "should Be true");
    Assertions.assertTrue(true, () -> "should Be true supplied");
  }
  @Test
  void simpleFail() {
    Assertions.assertTrue(false);
    Assertions.assertTrue(false, "should Be true");
    Assertions.assertTrue(false, () -> "should Be true supplied");
  }
}
