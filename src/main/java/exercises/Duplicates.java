package exercises;

import java.util.*;

public class Duplicates {
  public static void main(String[] args) {
    // Print repeatedChars
    String subject = "aaabbcdeffezzgzg";
    System.out.println("##Printing consecutive chars");
    printConsecutiveChars(subject);
    System.out.println("##Printing repeating chars");
    printRepeatedChars(subject);

    // Duplicate Strings
    String[] duplicateStrings = {"news", "news", "tests", "test", "what"};
    Integer[] duplicateIntegers = {1, 1, 2, 32, 45, 11, 11};
    Character[] duplicateChars = {'a', 'a', 'b', 'c', 'd', 'd'};
    System.out.println("## Duplicate Strings");
    Arrays.stream(removeDuplicated(duplicateStrings)).forEach(System.out::println);
    System.out.println("## Duplicate Integers");
    Arrays.stream(removeDuplicated(duplicateIntegers)).forEach(System.out::println);
    System.out.println("## Duplicate Chars");
    Arrays.stream(removeDuplicated(duplicateChars)).forEach(System.out::println);
  }

  private static <T> T[] removeDuplicated(T[] array) {
    List<Object> input = Arrays.asList(array);
    List<T> result = new ArrayList<>();
    Set<Object> distinct = new HashSet<>();
    for (Object current : input) {
      distinct.add(current);
    }

    result.addAll((Collection<? extends T>) distinct);
    return (T[]) result.toArray();
  }

  private static void printRepeatedChars(String subject) {
    Map<Character, Integer> letterCount = new HashMap<>();
    for(char current : subject.toCharArray()){
      if(letterCount.containsKey(current)){
        // Print only if it's first time finding the duplicate
        if(letterCount.get(current) == 1){
          System.out.println(current);
        }
        letterCount.put(current, letterCount.get(current) + 1);
        continue;
      }
      letterCount.put(current, 1);
    }
  }

  private static void printConsecutiveChars(String subject) {
    char[] characters = subject.toCharArray();
    char previous = 0;
    char printedChar = 0;
    for(int i=0; i< characters.length; i++) {
      if(previous == characters[i]){
        if(printedChar != previous) {
          System.out.println(previous);
          printedChar = previous;
        }
      }
      previous = characters[i];
    }
  }
}
