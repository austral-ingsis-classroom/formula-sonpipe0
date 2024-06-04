package edu.austral.ingsis.math;

import java.util.HashSet;
import java.util.Set;

public class VariableCollector implements ExpressionVisitor {

  private final Set<String> variables = new HashSet<>();

  @Override
  public void visit(Variable variable) {
    variables.add(variable.getName());
  }

  @Override
  public void visit(Constant constant) {
    return;
  }

  @Override
  public void visit(AbsoluteValue modulo) {
    modulo.getOperand().accept(this);
  }

  @Override
  public void visit(Root squareRoot) {
    squareRoot.getOperand().accept(this);
  }

  @Override
  public void visit(Addition addition) {
    addition.getLeft().accept(this);
    addition.getRight().accept(this);
  }

  @Override
  public void visit(Subtraction subtraction) {
    subtraction.getLeft().accept(this);
    subtraction.getRight().accept(this);
  }

  @Override
  public void visit(Multiplication multiplication) {
    multiplication.getLeft().accept(this);
    multiplication.getRight().accept(this);
  }

  @Override
  public void visit(Division division) {
    division.getLeft().accept(this);
    division.getRight().accept(this);
  }

  @Override
  public void visit(Power power) {
    power.getLeft().accept(this);
    power.getRight().accept(this);
  }

  public Set<String> getVariables() {
    return variables;
  }
}
