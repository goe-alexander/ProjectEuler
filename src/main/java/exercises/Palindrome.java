package exercises;

import java.math.BigDecimal;
import java.util.Arrays;

public class Palindrome {
  public static void main(String[] args) {
    System.out.println("### Palindrom tests");
    System.out.println("NonPalindrom test:");
    System.out.println(" is: 'AKKAN' a palindrome? " + isPalindromOnePass("AKKAN"));

    System.out.println("Palindrom test:");
    System.out.println(" is: 'AKKA' a palindrome? " + isPalindromOnePass("AKKA"));    System.out.println("### Palindrom tests");

    System.out.println("### Integer Palindrom Tests");
    System.out.println("NonPalindrom test:");
    System.out.println(" is: '1234' a palindrome? " + isIntegerPalindrome(1234));

    System.out.println("Palindrom test:");
    System.out.println(" is: '1221' a palindrome? " + isIntegerPalindrome(1221));

    System.out.println("## Factorial test");
    System.out.println("3! = " + factorial(56));
  }

  private static boolean isStringPalindrome(String subject) {
    char[] characters = subject.toCharArray();
    System.out.println("##LENGTH: " + characters.length);
    char[] reversed = new char[characters.length];
    for (int i = 0; i < characters.length; i++) {
      reversed[i] = characters[characters.length - i - 1];
    }
    return Arrays.equals(characters, reversed);
  }

  private static boolean isPalindromOnePass(String subject) {
    int i = 0;
    int j = subject.length() - 1;
    while (i < j) {
      if (subject.charAt(i) != subject.charAt(j)) {
        return false;
      }
      i++;
      --j;
    }
    return true;
  }

  private static boolean isIntegerPalindrome(Integer number) {
    Integer reversed = 0;
    Integer initial = number;
    while (initial != 0) {
      int digit = initial % 10;
      reversed = reversed * 10 + digit;
      initial /= 10;
    }
    return number.compareTo(reversed) == 0 ? true : false;
  }

  private static BigDecimal factorial(int number) {
      int i = 1; // Starting point
      BigDecimal sum = BigDecimal.ONE;
      while(i <= number) {
          sum = sum.multiply(new BigDecimal(i));
          i++;
      }
      return sum;
  }
}
