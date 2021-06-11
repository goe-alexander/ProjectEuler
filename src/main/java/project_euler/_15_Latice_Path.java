package project_euler;

import java.math.BigDecimal;

public class _15_Latice_Path {
  public static void main(String[] args) {
    long gridSize = 20;

    System.out.println(
        factorial(gridSize * 2).divide(factorial(gridSize).multiply(factorial(gridSize))));
  }

  private static BigDecimal factorial(long number) {
    BigDecimal result = BigDecimal.ONE;
    for (long i = 1; i <= number; i++) {
      result = result.multiply(BigDecimal.valueOf(i));
    }
    return result;
  }
}
