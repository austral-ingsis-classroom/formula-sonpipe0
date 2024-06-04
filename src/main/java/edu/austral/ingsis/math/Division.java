package edu.austral.ingsis.math;

import java.util.Map;

public class Division extends BinaryOperation {

  public Division(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public Double evaluate(Map<String, Double> values) {
    return getLeft().evaluate(values) / getRight().evaluate(values);
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visit(this);
  }
}
