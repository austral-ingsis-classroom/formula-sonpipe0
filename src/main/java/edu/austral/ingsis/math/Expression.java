package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;

public interface Expression {

  Double evaluate(Map<String, Double> values);

  Set<String> getVariables();

  void accept(ExpressionVisitor visitor);
}
