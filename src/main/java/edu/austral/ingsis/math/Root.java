package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;

public class Root implements Expression {

  private final Expression expression;

  public Root(Expression expression) {
    this.expression = expression;
  }

  public Expression getOperand() {
    return expression;
  }

  @Override
  public Double evaluate(Map<String, Double> values) {
    return Math.sqrt(expression.evaluate(values));
  }

  @Override
  public Set<String> getVariables() {
    return expression.getVariables();
  }

  @Override
  public void accept(ExpressionVisitor visitor) {}
}
