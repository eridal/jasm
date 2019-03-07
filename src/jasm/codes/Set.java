package jasm.codes;

import jasm.Addr;
import jasm.Inst;
import jasm.Processor;
import jasm.Program;

public class Set implements Inst {

  private final Addr target;
  private final int value;

  public Set(final Addr target,
             final int value) {
    this.target = target;
    this.value = value;
  }

  @Override public void execute(Processor machine, Program program) {
    target.set(machine, value);
  }

  @Override public String toCode() {
    return String.format("SET %s %d", target.toCode(), value);
  }

}
