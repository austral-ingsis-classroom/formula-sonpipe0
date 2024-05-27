package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Expression expression = new Addition(new Constant(1.0), new Variable("x"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);

    final Double result = expression.evaluate(variables);

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Expression expression = new Division(new Constant(12.0), new Variable("div"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("div", 4.0);

    final Double result = expression.evaluate(variables);

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Expression expression =
        new Multiplication(new Division(new Constant(9.0), new Variable("x")), new Variable("y"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);
    variables.put("y", 4.0);

    final Double result = expression.evaluate(variables);

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Expression expression =
        new Power(new Division(new Constant(27.0), new Variable("a")), new Variable("b"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("a", 9.0);
    variables.put("b", 3.0);

    final Double result = expression.evaluate(variables);

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Expression expression = new Root(new Variable("z"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("z", 36.0);

    final Double result = expression.evaluate(variables);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Expression expression =
        new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8.0));
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", 8.0);

    final Double result = expression.evaluate(variables);

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Expression expression =
        new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8.0));
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", 8.0);

    final Double result = expression.evaluate(variables);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Expression expression =
        new Multiplication(
            new Subtraction(new Constant(5.0), new Variable("i")), new Constant(8.0));
    Map<String, Double> variables = new HashMap<>();
    variables.put("i", 2.0);

    final Double result = expression.evaluate(variables);

    assertThat(result, equalTo(24d));
  }
}
