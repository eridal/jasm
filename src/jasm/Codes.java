package jasm;

import jasm.codes.Jump;
import jasm.codes.JumpIf;
import jasm.codes.JumpIfNot;
import jasm.codes.Label;
import jasm.codes.Move;
import jasm.codes.OpBin;
import jasm.codes.Print;
import jasm.codes.Set;

public final class Codes {

  private Codes() {
    throw new UnsupportedOperationException();
  }

  public static Inst SET(Addr target, int value) {
    return new Set(target, value);
  }

  public static Inst MOV(Addr from, Addr into) {
    return new Move(from, into);
  }

  public static Inst OUT(Addr addr) {
    return new Print(addr);
  }

  public static Inst JMP (int offset) {
    return new Jump(offset);
  }

  public static Inst JMP (String label) {
    return new Jump(label);
  }

  public static Inst JI (Addr cond, int offset) {
    return new JumpIf(cond, offset);
  }

  public static Inst JI (Addr cond, String label) {
    return new JumpIf(cond, label);
  }

  public static Inst JN (Addr cond, int offset) {
    return new JumpIfNot(cond, offset);
  }

  public static Inst JN (Addr cond, String label) {
    return new JumpIfNot(cond, label);
  }

  public static Inst ADD(Addr a, Addr b) {
    return new OpBin(OpBin.Func.ADD, a, b);
  }

  public static Inst SUB(Addr a, Addr b) {
    return new OpBin(OpBin.Func.SUB, a, b);
  }

  public static Inst MUL(Addr a, Addr b) {
    return new OpBin(OpBin.Func.MUL, a, b);
  }

  public static Inst DIV(Addr a, Addr b) {
    return new OpBin(OpBin.Func.DIV, a, b);
  }

  public static Inst MOD(Addr a, Addr b) {
    return new OpBin(OpBin.Func.MOD, a, b);
  }

  public static Inst EQ(Addr a, Addr b) {
    return new OpBin(OpBin.Func.EQ, a, b);
  }

  public static Inst NEQ(Addr a, Addr b) {
    return new OpBin(OpBin.Func.NEQ, a, b);
  }

  public static Inst LT(Addr a, Addr b) {
    return new OpBin(OpBin.Func.LT, a, b);
  }

  public static Inst LTE(Addr a, Addr b) {
    return new OpBin(OpBin.Func.LTE, a, b);
  }

  public static Inst GT(Addr a, Addr b) {
    return new OpBin(OpBin.Func.GT, a, b);
  }

  public static Inst GTE(Addr a, Addr b) {
    return new OpBin(OpBin.Func.GTE, a, b);
  }

  public static Inst LBL(String name) {
    return new Label(name);
  }
}
