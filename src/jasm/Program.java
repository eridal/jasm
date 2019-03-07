package jasm;

import jasm.codes.Label;

public class Program implements Code {

  private final Inst[] code;

  /**
   * Program counter
   */
  private int curr = 0;
  private int next;

  public Program(Inst[] code) {
    this.code = code;
  }

  public void jump(int next) {
    this.next = next;
  }

  public boolean tick (Processor processor) {

    final Inst inst = code[curr];

    System.out.println(inst.toCode());

    next = curr + 1;

    inst.execute(processor, this);

    curr = next;

    return curr < code.length;
  }

  @Override public String toCode() {
    final StringBuilder sb = new StringBuilder();
    for (final Inst inst : code) {
      sb.append(inst.toCode());
      sb.append('\n');
    }
    return sb.toString();
  }

  public int getLabelOffset(String name) {
    int index = 0;
    for (Inst inst : code) {
      if (inst instanceof Label && ((Label) inst).is(name)) {
        return index;
      }
      index += 1;
    }
    throw new IllegalArgumentException();
  }
}
