package jasm.codes;

import jasm.Code;
import jasm.Program;

public abstract class Offset implements Code {

  public static Offset of(int index) {
    return new Offset.Index(index);
  }

  public static Offset of(String label) {
    return new Offset.Label(label);
  }

  public abstract int get(Program program);

  private static class Index extends Offset {

    private final int index;

    public Index(int index) {
      this.index = index;
    }

    @Override public int get(Program program) {
      return index;
    }

    @Override public String toCode() {
      return String.valueOf(index);
    }
  }

  private static class Label extends Offset {

    private final String name;

    public Label(String name) {
      this.name = name;
    }

    @Override public int get(Program program) {
      return program.getLabelOffset(name);
    }

    @Override public String toCode() {
      return String.valueOf(name);
    }
  }
}
