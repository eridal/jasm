package jasm.codes;

import jasm.Addr;
import jasm.Inst;
import jasm.Processor;
import jasm.Program;

public class Print implements Inst {

  private final Addr addr;

  public Print(final Addr addr) {
    this.addr = addr;
  }

  @Override public void execute(final Processor machine,
                                final Program program) {

    final int val = addr.get(machine);
    System.out.println(val);
  }

  @Override public String toCode() {
    return String.format("OUT %s", addr.toCode());
  }
}
