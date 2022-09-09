package TwoPointers;

import java.util.HashSet;
import java.util.Locale;

public class ValidPalindrome {
    public static boolean isValidPalindrome(String s) {

        // initialise indexes at the start and end of the word
        int pointerA = 0, pointerB = s.length() - 1;

        // while the indexes have not crossed
        while (pointerA < pointerB) {

            // get the chars at these indexes
            char start = s.charAt(pointerA);
            char end = s.charAt(pointerB);

            // if start is not alphanumeric
            if (!Character.isLetterOrDigit(start)) {
                pointerA++;
                continue;
            }

            // if end is not alphanumeric
            if (!Character.isLetterOrDigit(end)) {
                pointerB--;
                continue;
            }

            // if the lower cases of the two pointers chars are different
            if(Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            pointerA++;
            pointerB--;
        }
        return true;
    }
}
