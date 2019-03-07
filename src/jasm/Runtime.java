package jasm;

@SuppressWarnings("unused")
public class Runtime {

  public static void main(String[] args) {
    final Inst[] code = createCounterFrom(10);
    final Processor machine = new Processor();
    final Program program = new Program(code);

    machine.add(program);

    boolean running = true;
    while (running) {
      running = machine.tick();
    }
  }

  /**
   * ```
   * print a + b
   * ```
   */
  private static Inst[] createSum(int a, int b) {
    return new Inst[] {
      Codes.SET(Addrs.$A, a),
      Codes.SET(Addrs.$B, b),
      Codes.ADD(Addrs.$A, Addrs.$B),
      Codes.OUT(Addrs.$R),
    };
  }

  /**
   *   i = 0
   * loop:
   *   print i
   *   i += 1
   *   goto loop
   */
  private static Inst[] createCounter() {
    return new Inst[] {
      Codes.SET(Addrs.$A, 0),           // a = 0
      Codes.SET(Addrs.$B, 1),           // $1
    // loop:
      Codes.OUT(Addrs.$A),              // print a
      Codes.ADD(Addrs.$A, Addrs.$B),    //
      Codes.MOV(Addrs.$R, Addrs.$A),    // a = a + $1
      Codes.JMP(2),                     // goto loop
    };
  }

  /**
   * Program:
   *    i = 0
   *    while a < 10 [
   *      print i
   *      i += 1
   *    ]
   *
   * Assembly:
   *    i = $0
   *  loop:
   *    if i < $10 [
   *       print i
   *       i += $1
   *       goto loop
   *    ]
   */
  private static Inst[] createCounterTill(int limit) {
    return new Inst[] {
      Codes.SET(Addrs.$A, 0),           // i = $0
      Codes.SET(Addrs.$B, 1),           // $1
      Codes.SET(Addrs.$C, limit),       // $10
      Codes.LBL("loop"),
      Codes.LT(Addrs.$A, Addrs.$C),     // if i < $10
      Codes.JN(Addrs.$R, "end"),            //
      Codes.OUT(Addrs.$A),              // print i
      Codes.ADD(Addrs.$A, Addrs.$B),    //
      Codes.MOV(Addrs.$R, Addrs.$A),    // a = a + $1
      Codes.JMP("loop"),                     // goto loop
      Codes.LBL("end"),
    };
  }
  
  /**
   *   i = 200
   *
   * loop:
   *   print i
   *   if i == 0 [
   *     goto end
   *   ]
   *   i -= 1
   *   goto loop
   * end:
   */
  private static Inst[] createCounterFrom(int from) {
    return new Inst[] {
        Codes.SET(Addrs.$A, from),     // i = 200
        Codes.SET(Addrs.$B, -1),      // -1
        Codes.SET(Addrs.$C, 0),       // 0

        Codes.OUT(Addrs.$A),

        Codes.EQ(Addrs.$A, Addrs.$C), // i == 0
        Codes.JI(Addrs.$R, 9),        // if

        Codes.ADD(Addrs.$A, Addrs.$B),
        Codes.MOV(Addrs.$R, Addrs.$A), // i -= 1
        Codes.JMP(3),                  // goto loop
    };
  }
}
