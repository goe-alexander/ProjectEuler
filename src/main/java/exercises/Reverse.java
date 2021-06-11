package exercises;


public class Reverse {
    public static void main(String[] args) {
    System.out.println("## Reversing string ");
    System.out.println("Alexandru Neagoe Valentin reversed: ");
    System.out.println(reverseString("Alexandru Neagoe Valentin"));

    System.out.println("Grigorescu Andreea reversed: ");
    System.out.println(reverseString("Grigorescu Andreea"));
    }

    private static String reverseString(String subject) {
        char[] characters = subject.toCharArray();
        System.out.println("##LENGTH: " + characters.length);
        char[] reversed = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[characters.length - i - 1];
        }
        return String.valueOf(reversed);
    }
}
