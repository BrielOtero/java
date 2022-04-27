
package com.exercise;

import com.chainString.ChainT;

public class Application {
  public static void main(String[] args) {

    ChainT chainT = new ChainT();

    System.out.print(chainT.checkSpaces("       text  To   Check      "));
    System.out.println("<--- Test");
    System.out.println();

    chainT.setString("   thisiiiiiiisatexti   ");
    System.out.println(chainT.toString());
    System.out.println(chainT.delete('i'));
    System.out.println(chainT.toString());

  }
}
