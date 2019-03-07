package jasm;

public class Processor {

  private Program program;
  private Register[] registers = new Register[] {
    new Register(),
    new Register(),
    new Register(),
    new Register(),
  };

  public void add (Program program) {
    this.program = program;
  }

  public boolean tick() {
    return program.tick(this);
  }

  public Register register(int reg) {
    return registers[reg];
  }

  public int add(int a, int b) {
    return Alu.add(this, a, b);
  }

  public int sub(int a, int b) {
    return Alu.sub(this, a, b);
  }

  public int mul(int a, int b) {
    return Alu.mul(this, a, b);
  }

  public int div(int a, int b) {
    return Alu.div(this, a, b);
  }

  public int mod(int a, int b) {
    return Alu.mod(this, a, b);
  }

  public int eq(int a, int b) {
    return Alu.eq(this, a, b);
  }

  public int neq(int a, int b) {
    return Alu.neq(this, a, b);
  }

  public int lt(int a, int b) {
    return Alu.lt(this, a, b);
  }

  public int lte(int a, int b) {
    return Alu.lt(this, a, b);
  }

  public int gt(int a, int b) {
    return Alu.gt(this, a, b);
  }

  public int gte(int a, int b) {
    return Alu.gt(this, a, b);
  }
}
