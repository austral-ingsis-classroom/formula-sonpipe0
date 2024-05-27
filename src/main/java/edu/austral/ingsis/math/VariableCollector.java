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
  public void visit(BinaryOperation expression) {
    expression.getLeft().accept(this);
    expression.getRight().accept(this);
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

  public Set<String> getVariables() {
    return variables;
  }
}
