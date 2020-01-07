package pf.zjava.junit5;

public class MultiplierTestCase {
  public Integer result;
  public Integer a;
  public Integer b;

  public MultiplierTestCase(Integer result, Integer a, Integer b) {
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

  public static MultiplierTestCase abcd(String s) {
    String[] splits = s.split("/");
    var result = Integer.parseInt(splits[0]);
    var a = Integer.parseInt(splits[1]);
    var b = Integer.parseInt(splits[2]);
    return new MultiplierTestCase(result, a, b);
  }
}
