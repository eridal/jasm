package jasm;

public interface Addr extends Code {

  public int get(Processor machine);

  public void set(Processor machine, int val);

}
