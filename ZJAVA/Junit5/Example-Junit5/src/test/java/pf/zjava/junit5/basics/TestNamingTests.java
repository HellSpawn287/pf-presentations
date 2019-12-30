package pf.zjava.junit5.basics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class TestNamingTests {
  @Test
  @DisplayName("test2")
  void test1(TestInfo info) {
    System.out.println("test1");
  }

  @Test
  @DisplayName("test1")
  void test2(TestInfo info) {
    System.out.println("test2");
  }
}
