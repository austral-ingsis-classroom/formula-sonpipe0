package edu.austral.ingsis.math;

public interface ExpressionVisitor {

  void visit(Root expression);

  void visit(Constant expression);

  void visit(AbsoluteValue expression);

  void visit(Variable expression);

  void visit(BinaryOperation expression);
}
