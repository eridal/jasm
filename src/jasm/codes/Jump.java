package jasm.codes;

import jasm.Inst;
import jasm.Processor;
import jasm.Program;

public class Jump implements Inst {

  private final Offset offset;

  public Jump(Offset offset) {
    this.offset = offset;
  }

  public Jump(int index) {
    this(Offset.of(index));
  }

  public Jump(String label) {
    this(Offset.of(label));
  }

  @Override public void execute(Processor machine, Program program) {
    int index = offset.get(program);
    program.jump(index);
  }

  @Override public String toCode() {
    return String.format("JMP %s", offset.toCode());
  }

}
