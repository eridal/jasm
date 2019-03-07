package jasm.codes;

import jasm.Addr;
import jasm.Inst;
import jasm.Processor;
import jasm.Program;

public class Move implements Inst {

  final Addr from;
  final Addr into;

  public Move (Addr from,  Addr into) {
    this.from = from;
    this.into = into;
  }

  @Override public void execute(final Processor machine,
                                final Program program) {

    final int val = from.get(machine);

    into.set(machine, val);
  }

  @Override public String toCode() {
    return String.format("MOV %s %s", from.toCode(), into.toCode());
  }

}