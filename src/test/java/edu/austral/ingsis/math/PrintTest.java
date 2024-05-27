package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    final Expression expression = new Addition(new Constant(1), new Constant(6));
    final String result = Printer.print(expression);

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final Expression expression = new Division(new Constant(12), new Constant(2));
    final String result = Printer.print(expression);

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final Expression expression =
        new Multiplication(new Division(new Constant(9), new Constant(2)), new Constant(3));
    final String result = Printer.print(expression);

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final Expression expression =
        new Power(new Division(new Constant(27), new Constant(6)), new Constant(2));
    final String result = Printer.print(expression);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final Expression expression =
        new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8));
    final String result = Printer.print(expression);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final Expression expression =
        new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8));
    final String result = Printer.print(expression);

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final Expression expression =
        new Multiplication(new Subtraction(new Constant(5), new Variable("i")), new Constant(8));
    final String result = Printer.print(expression);

    assertThat(result, equalTo(expected));
  }
}
