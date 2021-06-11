package exercises;

public class MathOperations {
  public static void main(String[] args) {
    System.out.println("Getting square root of: ");
    System.out.println("25: " + getSquareRoot(25.0, 0.0000001));
  }

  private static Double getSquareRoot(Double number, Double precision) {
    double x = number;
    double root;

    int count = 0;
    while (true) {
      count++;
      root = 0.5 * (x + (number / x));
      // Check for closeness
      if (Math.abs(root - x) < precision) break;
      x = root;
    }
    return root;
  }
}
