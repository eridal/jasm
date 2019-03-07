package jasm;

public final class Addrs {

  private Addrs() {
    throw new UnsupportedOperationException();
  }

  public static final Addr $R = new RegisterAddr("$r", Register.$R);
  public static final Addr $A = new RegisterAddr("$a", Register.$A);
  public static final Addr $B = new RegisterAddr("$b", Register.$B);
  public static final Addr $C = new RegisterAddr("$c", Register.$C);

  private static class RegisterAddr implements Addr {

    private final String name;
    private final int reg;

    public RegisterAddr(String name, int reg) {
      this.name = name;
      this.reg = reg;
    }

    @Override public int get(Processor machine) {
      return machine
        .register(reg)
        .get();
    }

    @Override public void set(Processor machine, int val) {
      machine
        .register(reg)
        .set(val);
    }

    @Override public String toCode() {
      return name;
    }
  }
}
