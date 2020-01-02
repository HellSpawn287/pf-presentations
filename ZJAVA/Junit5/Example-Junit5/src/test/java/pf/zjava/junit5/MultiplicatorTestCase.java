package pf.zjava.junit5;

public class MultiplicatorTestCase {
  public Integer result;
  public Integer a;
  public Integer b;

  public MultiplicatorTestCase(Integer result, Integer a, Integer b) {
    this.result = result;
    this.a = a;
    this.b = b;
  }

  @Override
  public String toString() {
    return "TestCase{" +
        "result=" + result +
        ", a=" + a +
        ", b=" + b +
        '}';
  }

  public static MultiplicatorTestCase abcd(String s) {
    String[] splits = s.split("/");
    var result = Integer.parseInt(splits[0]);
    var a = Integer.parseInt(splits[1]);
    var b = Integer.parseInt(splits[2]);
    return new MultiplicatorTestCase(result, a, b);
  }
}
