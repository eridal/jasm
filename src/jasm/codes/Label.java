package jasm.codes;

import jasm.Inst;
import jasm.Processor;
import jasm.Program;

public class Label implements Inst {

  public final String name;

  public Label(String name) {
    this.name = name;
  }

  @Override public void execute(Processor machine, Program program) {
    // labels dont do anything
  }

  @Override public String toCode() {
    return String.format("%s:", name);
  }

  public boolean is(String name) {
    return this.name.equals(name);
  }
}
