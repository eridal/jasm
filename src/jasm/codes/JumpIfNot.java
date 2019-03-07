package jasm.codes;

import jasm.Addr;
import jasm.Inst;
import jasm.Processor;
import jasm.Program;

public class JumpIfNot implements Inst {

  private final Addr cond;
  private final Offset offset;

  public JumpIfNot(Addr cond, Offset offset) {
    this.cond = cond;
    this.offset = offset;
  }

  public JumpIfNot(Addr cond, int offset) {
    this(cond, Offset.of(offset));
  }

  public JumpIfNot(Addr cond, String label) {
    this(cond, Offset.of(label));
  }

  @Override public void execute(Processor machine, Program program) {

    int val = cond.get(machine);
    int res = machine.eq(val, 0);

    if (res == 0) {
      int index = offset.get(program);
      program.jump(index);
    }
  }

  @Override public String toCode() {
    return String.format("JI %s %s", cond.toCode(), offset.toCode());
  }
}
