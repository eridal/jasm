package jasm.codes;

import jasm.Addr;
import jasm.Code;
import jasm.Inst;
import jasm.Processor;
import jasm.Program;

public class OpBin implements Inst {

  final Func f;
  final Addr a;
  final Addr b;

  public OpBin (Func f, Addr a, Addr b) {
    this.f = f;
    this.a = a;
    this.b = b;
  }

  @Override public void execute(final Processor machine,
      final Program program) {

    final int v1 = a.get(machine);
    final int v2 = b.get(machine);

    f.apply(machine, v1, v2);
  }

  @Override public String toCode() {
    return String.format("%s %s %s", f.toCode(), a.toCode(), b.toCode());
  }

  public static enum Func implements Code {
    ADD() {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.add(a,  b);
      }
    },
    SUB() {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.sub(a,  b);
      }
    },
    MUL() {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.mul(a,  b);
      }
    },
    DIV() {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.div(a,  b);
      }
    },
    MOD() {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.mod(a,  b);
      }
    },
    EQ () {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.eq(a,  b);
      }
    },
    NEQ () {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.neq(a,  b);
      }
    },
    LT () {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.lt(a,  b);
      }
    },
    LTE () {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.lte(a,  b);
      }
    },
    GT () {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.gt(a,  b);
      }
    },
    GTE () {
      @Override void apply(final Processor machine,
                           final int a,
                           final int b) {
        machine.gte(a,  b);
      }
    },
    ;

    abstract void apply(final Processor machine,
                        final int a,
                        final int b);

    @Override public String toCode() {
      return name();
    }
  }
}
