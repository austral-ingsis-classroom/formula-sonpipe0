package edu.austral.ingsis.math;

public class Printer {

  public static String print(Expression expression) {
    PrinterVisitor printerVisitor = new PrinterVisitor();
    expression.accept(printerVisitor);
    return printerVisitor.getResult();
  }
}
