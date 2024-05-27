package edu.austral.ingsis.math;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Expression expression = new Addition(new Constant(1.0), new Constant(6.0));
    final Double result = expression.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Expression expression = new Division(new Constant(12.0), new Constant(2.0));
    final Double result = expression.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Expression expression = new Multiplication(new Division(new Constant(9.0), new Constant(2.0)), new Constant(3.0));
    final Double result = expression.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(13.5));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Expression expression = new Power(new Division(new Constant(27.0), new Constant(6.0)), new Constant(2.0));
    final Double result = expression.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(20.25));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Expression expression = new Root(new Constant(36.0));
    final Double result = expression.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Expression expression = new AbsoluteValue(new Constant(136.0));
    final Double result = expression.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Expression expression = new AbsoluteValue(new Constant(-136.0));
    final Double result = expression.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Expression expression = new Multiplication(new Subtraction(new Constant(5.0), new Constant(5.0)), new Constant(8.0));
    final Double result = expression.evaluate(Collections.emptyMap());

    assertThat(result, equalTo(0d));
  }
}
