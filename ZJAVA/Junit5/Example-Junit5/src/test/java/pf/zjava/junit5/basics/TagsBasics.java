package pf.zjava.junit5.basics;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class TagsBasics {
  @Test
  @Tags({
      @Tag("a"),
      @Tag("b")
  })
  void test1(TestInfo info) {
    System.out.println("test1");
  }

  @Test
  @Tag("b")
  void test2(TestInfo info) {
    System.out.println("test2");
  }

  @Test
  void test3(TestInfo info) {
    System.out.println("test3");
  }
}
