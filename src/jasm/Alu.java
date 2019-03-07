package jasm;

public class Alu {

  public static int add(Processor machine, int a, int b) {
    final int res = a + b;
    return set(machine, res);
  }

  public static int sub(Processor machine, int a, int b) {
    final int res = a - b;
    return set(machine, res);
  }

  public static int mul(Processor machine, int a, int b) {
    final int res = a * b;
    return set(machine, res);
  }

  public static int div(Processor machine, int a, int b) {
    final int res = a / b;
    return set(machine, res);
  }

  public static int mod(Processor machine, int a, int b) {
    final int res = a ^ b;
    return set(machine, res);
  }

  public static int eq(Processor machine, int a, int b) {
    final boolean res = a == b;
    return set(machine, res);
  }

  public static int neq(Processor machine, int a, int b) {
    final boolean res = a != b;
    return set(machine, res);
  }

  public static int lt(Processor machine, int a, int b) {
    final boolean res = a < b;
    return set(machine, res);
  }

  public static int lte(Processor machine, int a, int b) {
    final boolean res = a <= b;
    return set(machine, res);
  }
  
  public static int gt(Processor machine, int a, int b) {
    final boolean res = a > b;
    return set(machine, res);
  }

  public static int gte(Processor machine, int a, int b) {
    final boolean res = a >= b;
    return set(machine, res);
  }

  private static int set(Processor machine, int res) {
    machine
    .register(Register.$R)
    .set(res);
    return res;
  }

  private static int set (Processor machine, boolean res) {
    final int val = res ? 0 : 1;
    set(machine, val);
    return val;
  }
}
