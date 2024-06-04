package edu.austral.ingsis.math;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class BinaryOperation implements Expression {

  private final Expression left;
  private final Expression right;

  public BinaryOperation(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  public Expression getLeft() {
    return left;
  }

  public Expression getRight() {
    return right;
  }

  @Override
  public abstract Double evaluate(Map<String, Double> values);

  @Override
  public Set<String> getVariables() {
    Set<String> variables = new HashSet<>();
    variables.addAll(left.getVariables());
    variables.addAll(right.getVariables());
    return variables;
  }
}
