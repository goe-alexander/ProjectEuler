package project_euler;

import java.util.ArrayList;
import java.util.List;

public class _12_Highly_divisible_triangle_number {
  public static void main(String[] args) {
    long number = 1;
    while (1 == 1) {
      if (isTriangular(number)) {
        System.out.println("Found triangular: " + number);
        if (noOfDivisors(number) > 500) {
          System.out.println("#### WINNER! ######");
          break;
        }
      }
      number++;
    }
  }

  private static boolean isTriangular(long num) {
    if (num < 0) return false;
    long sum = 0;
    for (long i = 1; sum <= num; i++) {
      sum = sum + i;
      if (sum == num) {
        return true;
      }
    }
    return false;
  }

  private static int noOfDivisors(long triangularNo) {
    List<Integer> divisors = new ArrayList<>();
    for (int i = 1; i <= triangularNo / 2; i++) {
      if (triangularNo % i == 0) {
        divisors.add(i);
      }
    }
    System.out.println("Divisors: " + divisors.size());
    return divisors.size();
  }
}
