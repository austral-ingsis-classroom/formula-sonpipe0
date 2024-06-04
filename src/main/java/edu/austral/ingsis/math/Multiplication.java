package edu.austral.ingsis.math;

import java.util.Map;

public class Multiplication extends BinaryOperation {

  public Multiplication(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public Double evaluate(Map<String, Double> values) {
    return getLeft().evaluate(values) * getRight().evaluate(values);
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visit(this);
  }
}
