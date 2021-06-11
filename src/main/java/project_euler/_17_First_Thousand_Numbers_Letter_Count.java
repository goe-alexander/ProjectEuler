package project_euler;

import java.util.HashMap;
import java.util.Map;

public class _17_First_Thousand_Numbers_Letter_Count {
  static Map<Integer, String> firstTwenty =
      new HashMap<Integer, String>() {
        {
          put(1, "One");
          put(2, "Two");
          put(3, "Three");
          put(4, "Four");
          put(5, "Five");
          put(6, "Six");
          put(7, "Seven");
          put(8, "Eight");
          put(9, "Nine");
          put(10, "Ten");
          put(11, "Eleven");
          put(12, "Twelve");
          put(13, "Thirteen");
          put(14, "Fourteen");
          put(15, "Fifteen");
          put(16, "Sixteen");
          put(17, "Seventeen");
          put(18, "Eighteen");
          put(19, "Nineteen");
          put(20, "Twenty");
        }
      };

  static Map<Integer, String> tens =
      new HashMap<Integer, String>() {
        {
          put(20, "Twenty");
          put(30, "Thirty");
          put(40, "Forty");
          put(50, "Fifty");
          put(60, "Sixty");
          put(70, "Seventy");
          put(80, "Eighty");
          put(90, "Ninety");
        }
      };

  static String hundred = "hundred";
  static String thousand = "OneThousand";

  public static void main(String[] args) {
    long count = 0;

    for (int i = 1; i < 1000; i++) {
      String letterNo = getLetterNumber(i);
      System.out.println(letterNo);
      count += letterNo.length();
    }
    count += thousand.length();
    System.out.println("Entire lenght: " + count);
  }

  private static String getLetterNumber(int number) {
    String letterNumber = "";
    char[] digits = String.valueOf(number).toCharArray();
    int size = String.valueOf(number).length();
    if (number <= 20) {
      letterNumber = firstTwenty.get(number);
    } else if (size == 2) {
      letterNumber =
          tens.get(Integer.valueOf(new StringBuilder().append(digits[0]).append(0).toString()));
      letterNumber = letterNumber + firstTwenty.get(Character.getNumericValue(digits[1]));
    } else if (size == 3) {
      letterNumber = firstTwenty.get(Character.getNumericValue(digits[0])) + hundred;
      if(digits[1] == '0' ?  digits[2] != '0' : true){
        letterNumber = letterNumber + "and";
      }
      if(Character.getNumericValue(digits[1]) == 0) {
        letterNumber = letterNumber + firstTwenty.get(Character.getNumericValue(digits[2]));
      }
      else if(Character.getNumericValue(digits[1]) == 1) {
        letterNumber = letterNumber + firstTwenty.get(Integer.valueOf(new StringBuilder().append(digits[1]).append(digits[2]).toString()));
      } else {
        letterNumber = letterNumber + tens.get(Integer.valueOf(new StringBuilder().append(digits[1]).append(0).toString()));
        letterNumber = letterNumber + firstTwenty.get(Character.getNumericValue(digits[2]));
      }
    }
    return letterNumber.replace("null", "");
  }
}
