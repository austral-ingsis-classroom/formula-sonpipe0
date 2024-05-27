package edu.austral.ingsis.math;

import java.util.Map;

public class Power extends BinaryOperation {

  public Power(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public Double evaluate(Map<String, Double> values) {
    return Math.pow(getLeft().evaluate(values), getRight().evaluate(values));
  }

  @Override
  public String getOperand() {
    return "^";
  }
}
