package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;

public class AbsoluteValue implements Expression {

  private final Expression operand;

  public AbsoluteValue(Expression operand) {
    this.operand = operand;
  }

  public Expression getOperand() {
    return operand;
  }

  @Override
  public Double evaluate(Map<String, Double> variables) {
    return Math.abs(operand.evaluate(variables));
  }

  @Override
  public Set<String> getVariables() {
    return operand.getVariables();
  }

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visit(this);
  }
}
