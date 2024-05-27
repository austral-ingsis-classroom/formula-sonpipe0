package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    // Arrange
    Expression expression = new Addition(new Constant(1), new Constant(6));
    VariableCollector collector = new VariableCollector();

    // Act
    expression.accept(collector);
    List<String> result = List.copyOf(collector.getVariables());

    // Assert
    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    // Arrange
    Expression expression = new Division(new Constant(12), new Variable("div"));
    VariableCollector collector = new VariableCollector();

    // Act
    expression.accept(collector);
    List<String> result = List.copyOf(collector.getVariables());

    // Assert
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    // Arrange
    Expression expression =
        new Multiplication(new Division(new Constant(9), new Variable("x")), new Variable("y"));
    VariableCollector collector = new VariableCollector();

    // Act
    expression.accept(collector);
    List<String> result = List.copyOf(collector.getVariables());

    // Assert
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    // Arrange
    Expression expression =
        new Power(new Division(new Constant(27), new Variable("a")), new Variable("b"));
    VariableCollector collector = new VariableCollector();

    // Act
    expression.accept(collector);
    List<String> result = List.copyOf(collector.getVariables());

    // Assert
    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    // Arrange
    Expression expression = new Power(new Variable("z"), new Constant(0.5));
    VariableCollector collector = new VariableCollector();

    // Act
    expression.accept(collector);
    List<String> result = List.copyOf(collector.getVariables());

    // Assert
    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    // Arrange
    Expression expression =
        new Subtraction(new AbsoluteValue(new Variable("value")), new Constant(8));
    VariableCollector collector = new VariableCollector();

    // Act
    expression.accept(collector);
    List<String> result = List.copyOf(collector.getVariables());

    // Assert
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    // Arrange
    Expression expression =
        new Subtraction(new Constant(8), new AbsoluteValue(new Variable("value")));
    VariableCollector collector = new VariableCollector();

    // Act
    expression.accept(collector);
    List<String> result = List.copyOf(collector.getVariables());

    // Assert
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    // Arrange
    Expression expression =
        new Multiplication(new Subtraction(new Constant(5), new Variable("i")), new Constant(8));
    VariableCollector collector = new VariableCollector();

    // Act
    expression.accept(collector);
    List<String> result = List.copyOf(collector.getVariables());

    // Assert
    assertThat(result, containsInAnyOrder("i"));
  }
}
