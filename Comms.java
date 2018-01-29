import java.util.*;
import java.io.*;

public class Comms {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] rotorNum = new int[3];
    for (int i=0;i<3;i++) {
      rotorNum[i] = Integer.parseInt(args[i]);
    }

    String orient = args[3];
    String e_d = args[4];
    String input = sc.next();

    Enigma machine = new Enigma(rotorNum, orient);

    if ((e_d.compareToIgnoreCase("encrypt")) == 0) {
      String output = machine.encrypt(input);
      System.out.println(output);
    } else if ((e_d.compareToIgnoreCase("decrypt")) == 0) {
      String output = machine.decrypt(input);
      System.out.println(output);
    } else {
      System.out.println("You entered an invalid command");
    }
  }
}
