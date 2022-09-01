package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    // improved solution
    public boolean IsAnagram(String original, String anagram) {
        char[] originalArr = original.toCharArray();
        char[] anagramArr = anagram.toCharArray();

        if (originalArr.length != anagramArr.length) return false;
        Arrays.sort(originalArr);
        Arrays.sort(anagramArr);
        for (int i = 0; i < originalArr.length; i++) {
            if (originalArr[i] != anagramArr[i]) return false;
        }
        return true;
    }
}

// while correct, this solution is slow. What I could do (I now know this) is sort each string characters alphabetically
// and simply compare each character
//    public static boolean IsAnagram(String original, String anagram)
//    {
//        HashMap<Character, Integer> letters = new HashMap<>();
//        PutStringInHashmap(original, letters);
//        return CheckAnagram(anagram, letters);
//    }
//
//    static void PutStringInHashmap(String original, HashMap<Character, Integer> letters)
//    {
//        for(char c : original.toCharArray()) {
//            if (letters.containsKey(c)) {
//                letters.put(c, letters.get(c) + 1);
//            } else {
//                letters.put(c, 1);
//            }
//        }
//    }
//
//    static boolean CheckAnagram(String anagram, HashMap<Character, Integer> letters) {
//        for (char c : anagram.toCharArray()) {
//            if (!letters.containsKey(c)) return false;
//            letters.put(c, letters.get(c) - 1);
//
//            if (letters.get(c) == 0) {
//                letters.remove(c);
//            }
//        }
//        return letters.isEmpty();
//    }
//}
