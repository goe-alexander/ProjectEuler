package project_euler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class _10_SumationOfPrimes {
  public static void main(String[] args) {
    int limit = 2_000_000;
    LongStream stream = LongStream.range(2, 2_000_000);
    List<Long> primes = new CopyOnWriteArrayList<>();
    stream
        .parallel()
        .map(
            element -> {
              if (isPrimeNumber(element)) {
                primes.add(element);
              }
              return element;
            })
        .count();
    System.out.println(primes.stream().mapToLong(Long::longValue).sum());
  }

  private static LongPredicate isPrime() {
    return element -> isPrimeNumber(element);
  }

  private static boolean isPrimeNumber(long number) {
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    System.out.println("#### Found Prime: " + number);
    return true;
  }
}
