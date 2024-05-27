package edu.austral.ingsis.math;

import java.util.Map;

public class Subtraction extends BinaryOperation{

  public Subtraction(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public Double evaluate(Map<String, Double> values) {
    return getLeft().evaluate(values) - getRight().evaluate(values);
  }

  @Override
  public String getOperand() {
    return "-";
  }
}
