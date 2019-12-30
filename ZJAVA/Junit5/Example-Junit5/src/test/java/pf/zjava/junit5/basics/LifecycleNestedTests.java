package pf.zjava.junit5.basics;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class LifecycleNestedTests {
  @BeforeAll
  static void setupAll() {
    System.out.println("BeforeAll");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("AfterAll");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("BeforeEach");
  }

  @AfterEach
  void afterEach() {
    System.out.println("afterEach");
  }

  @Test
  void test1(TestInfo info) {
    System.out.println("test1");
  }

  @Test
  void test2(TestInfo info) {
    System.out.println("test2");
  }
  @Nested
  public class NestedTest {

    @BeforeEach
    void beforeEach() {
      System.out.println("BeforeEachNested");
    }

    @AfterEach
    void afterEach() {
      System.out.println("afterEachNested");
    }

    @Test
    void test1(TestInfo info) {
      System.out.println("test1Nested");
    }

    @Test
    void test2(TestInfo info) {
      System.out.println("test2Nested");
    }


  }
}
