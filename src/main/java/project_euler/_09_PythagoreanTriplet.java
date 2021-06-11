package project_euler;

public class _09_PythagoreanTriplet {
  public static void main(String[] args) {
    int a;
    int b;
    int c;
    int targetSum = 1000;
    for (int i = 1; i <= 1000; i++) {
      a = i;
      for (int j = 1; j <= 1000; j++) {
        b = j;
        c = 1000 - (a + b);
        if (isTargetSum(a, b, c)) {
          if (isPythagoreanTriplet(a, b, c)) {
            System.out.println("Found triplet: " + a + "/" + b + "/" + c);
            System.out.println("Product: " + (a * b * c));
          }
        }
      }
    }
  }

  private static boolean isPythagoreanTriplet(int a, int b, int c) {
    return (a * a) + (b * b) == c * c;
  }

  private static boolean isTargetSum(int a, int b, int c) {
    return a + b + c == 1000;
  }
}
