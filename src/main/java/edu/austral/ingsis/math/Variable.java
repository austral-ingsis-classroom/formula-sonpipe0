package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;

public class Variable implements Expression {

  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public Double evaluate(Map<String, Double> values) {
    return values.get(name);
  }

  @Override
  public Set<String> getVariables() {
    return Set.of(name);
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visit(this);
  }
}
