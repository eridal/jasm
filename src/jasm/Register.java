package jasm;

public class Register {

  private int value;

  public int get() {
    return value;
  }

  public void set(int value) {
    this.value = value;
  }

  public static final int $R = 0;
  public static final int $A = 1;
  public static final int $B = 2;
  public static final int $C = 3;
}
