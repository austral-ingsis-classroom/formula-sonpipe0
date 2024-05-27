package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;

public class Constant implements Expression{

  private final Double value;

  public Constant(double value) {
    this.value = value;
  }


  @Override
  public Double evaluate(Map<String,Double> values) {
    return value;
  }

  @Override
  public Set<String> getVariables() {
    return null;
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visit(this);
  }

  public Double getValue() {
    return value;
  }
}
