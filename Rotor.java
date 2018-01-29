/*
- To find .toCharArray, I looked through the java String documentation online
*/

import java.util.*;
import java.io.*;

public class Rotor {
  private char[] contents;
  private int num_rotate;

  public Rotor(int rotorNum) {
    String[] temp = new String[] {
      "#GNUAHOVBIPWCJQXDKRYELSZFMT",
      "#EJOTYCHMRWAFKPUZDINSXBGLQV",
      "#BDFHJLNPRTVXZACEGIKMOQSUWY",
      "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
      "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    this.contents = temp[rotorNum-1].toCharArray();
    this.num_rotate = 0;
  }

  public int getNumRotate() {
    return this.num_rotate;
  }

  public void rotate() {
    char temp = this.contents[26];
    for (int i=this.contents.length-1;i>0;i--) {
      this.contents[i] = this.contents[i-1];
    }
    this.contents[0] = temp;
    this.num_rotate++;
  }

  public void setRotor(char top) {
    if (this.contents[0] == top) {
      this.num_rotate = 0;
    } else {
      this.rotate();
      this.setRotor(top);
    }
  }

  public int char2int(char input) {
    int i = 0;
    while (this.contents[i] != input) {i++;}
    //System.out.println("We got "+this.contents[i]+" -> "+i);
    return i;
  }

  public char int2char(int input) {
    //System.out.println("we got"+this.contents[input]);
    return this.contents[input];
  }
}
