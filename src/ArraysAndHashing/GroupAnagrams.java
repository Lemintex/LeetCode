package ArraysAndHashing;

import java.util.*;

public class GroupAnagrams {
    // this solution is INCREDIBLY slow on larger data sets (On^2, and is already really slow based on anagram lookup)
    // TODO: make not slow
    public static List<List<String>> groupAnagrams(String[] strings) {
        // initialise list of list of strings
        List<List<String>> groups = new ArrayList<>();

        // initialise list of character arrays
        List<char[]> alphabeticalAnagrams = new ArrayList<>();

        // for each string given
        for (String s : strings) {
            // has an anagram been found
            boolean found = false;

            // sorts string chars alphabetically
            char[] copy = s.toCharArray();
            Arrays.sort(copy);

            // for every anagram found already
            for (int i = 0; i < alphabeticalAnagrams.size(); i++) {
                // get the alphabetical char array
                char[] anagram = alphabeticalAnagrams.get(i);

                // if sizes aren't the same they're not anagrams
                if (copy.length != anagram.length) continue;

                // compare every character in arrays
                boolean same = true;
                for(int j = 0; j < copy.length; j++) {
                    // if these are different they are not anagrams
                    if (copy[j] != anagram[j]) {
                        same = false;
                        break;
                    }
                }
                // if same flag is true they are anagrams
                if (same) {
                    // add the word to the right group
                    groups.get(i).add(s);
                    found = true;
                    break;
                }
            }
            if (!found) {
                // if no anagram found, add a new group (List) with the word
                List<String> l = new ArrayList<>();
                l.add(s);
                groups.add(l);

                // add the alphabetical array to the comparison list
                alphabeticalAnagrams.add(copy);
            }
        }
        return groups;
    }

    // this solution is much faster (On) as it uses a HashMap for instant anagram lookup
    public static List<List<String>> groupAnagramsFaster(String[] strings) {
        // hashmap is used to story groups of anagrams and letter combinations
        // key is string of alphabetical letters in anagram combination
        // value is list of every anagram of these letters
        HashMap<String, List<String>> alphabeticalAnagrams = new HashMap<>();

        // for each string given
        for (String s : strings) {
            // sorts string chars alphabetically
            char[] copy = s.toCharArray();
            Arrays.sort(copy);
            String letters = String.valueOf(copy);

            // adds
            ArrayList<String> lst = (ArrayList<String>) alphabeticalAnagrams.getOrDefault(letters, new ArrayList<>());
            lst.add(s);
            alphabeticalAnagrams.putIfAbsent(letters, lst);
        }
        // returns a list of every group
        return new ArrayList<>(alphabeticalAnagrams.values());
    }
}