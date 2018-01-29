import java.util.*;
import java.io.*;

public class Enigma {
  private Rotor inner;
  private Rotor middle;
  private Rotor outer;

  public Enigma(int[] rotorNum, String orientation) {
    inner = new Rotor(rotorNum[0]);
    middle = new Rotor(rotorNum[1]);
    outer = new Rotor(rotorNum[2]);
    this.setEnigma(orientation);
  }

  public void setEnigma(String orientation) {
    char[] temp = orientation.toCharArray();
    this.inner.setRotor(temp[0]);
    this.middle.setRotor(temp[1]);
    this.outer.setRotor(temp[2]);
  }

  public String decrypt(String input) {
    char[] temp = input.toCharArray();
    char[] tempOut = new char[temp.length];
    for (int i=0;i<temp.length;i++) {
      tempOut[i] = decryptChar(temp[i]);
      this.inner.rotate();
      if ((this.inner.getNumRotate() % 27) == 0) {
        this.middle.rotate();
        if ((this.middle.getNumRotate() % 27) == 0) {
          this.outer.rotate();
        }
      }
    }

    String output = new String(tempOut);

    return output;
  }

  public String encrypt(String input) {
    char[] temp = input.toCharArray();
    char[] tempOut = new char[temp.length];
    for (int i=0;i<temp.length;i++) {
      tempOut[i] = encryptChar(temp[i]);
      this.inner.rotate();
      //System.out.println("Rotate Inner");
      if ((this.inner.getNumRotate() % 27) == 0) {
        this.middle.rotate();
        //System.out.println("Middle");
        if ((this.middle.getNumRotate() % 27) == 0) {
          this.outer.rotate();
          //System.out.println("Outer");
        }
      }
    }

    String output = new String(tempOut);

    return output;
  }

  private char encryptChar(char input) {
    int tempLoc = this.inner.char2int(input);
    char tempChar = this.outer.int2char(tempLoc);
    tempLoc = this.middle.char2int(tempChar);
    return this.outer.int2char(tempLoc);
  }

  private char decryptChar(char input) {
    int tempLoc = this.outer.char2int(input);
    char tempChar = this.middle.int2char(tempLoc);
    tempLoc = this.outer.char2int(tempChar);
    return this.inner.int2char(tempLoc);
  }
}
