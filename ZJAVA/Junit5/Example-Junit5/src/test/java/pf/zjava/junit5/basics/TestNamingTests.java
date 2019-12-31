package pf.zjava.junit5.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class TestNamingTests {
  public  String name = "test2 new " + new String(Character.toChars(0x1F349));
  @Test
  @DisplayName(value = "test \u26C4")
  void test1(TestInfo info) {
    System.out.println("test1");
    Assertions.fail();
  }

  @Test
  @DisplayName("test1")
  void test2(TestInfo info) {
    System.out.println("test2");
    Assertions.fail();
  }
}
