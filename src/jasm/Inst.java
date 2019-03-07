package jasm;

public interface Inst extends Code {

  public void execute(final Processor machine,
                      final Program program);

}
