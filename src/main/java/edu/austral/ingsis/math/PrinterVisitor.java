package edu.austral.ingsis.math;

public class PrinterVisitor implements ExpressionVisitor {

  private final StringBuilder stringBuilder;

  private int level = 0;

  public PrinterVisitor() {
    this.stringBuilder = new StringBuilder();
  }

  public String getResult() {
    return stringBuilder.toString();
  }

  @Override
  public void visit(Constant constant) {
    stringBuilder.append(Integer.toString(constant.getValue().intValue()));
  }

  @Override
  public void visit(Variable variable) {
    stringBuilder.append(variable.getName());
  }

  @Override
  public void visit(BinaryOperation expression) {
    level++;
    if (level > 1) stringBuilder.append("(");
    expression.getLeft().accept(this);
    stringBuilder.append(" ");
    stringBuilder.append(expression.getOperand());
    stringBuilder.append(" ");
    expression.getRight().accept(this);
    if (level > 1) stringBuilder.append(")");
    level--;
  }

  @Override
  public void visit(Root root) {
    stringBuilder.append("√(");
    root.getOperand().accept(this);
    stringBuilder.append(")");
  }

  @Override
  public void visit(AbsoluteValue absoluteValue) {
    stringBuilder.append("|");
    absoluteValue.getOperand().accept(this);
    stringBuilder.append("|");
  }
}
