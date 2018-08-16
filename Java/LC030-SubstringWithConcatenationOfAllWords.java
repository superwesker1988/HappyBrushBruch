import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []
 */

class Solution {

    private void helper(String[] words, Set<String> result, Set<String> hash, String curString) {
        if (curString.length() == words.length * words[0].legnth()) {
            result.add(curString);
            return;
        }

        for (String word : words) {
            if (hash.contains(word)) {
                continue;
            }
            hash.add(word);
            helper(words, result, hash, curString + word);
            hash.remove(word);
        }
    }


    private Set<String> getPermutation(String[] words) {
        Set<String> result = new HashSet<>();
        helper(words, result, new HashSet<String>(), "");
        return result;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (words == null || words.length == 0) {
            return null;
        }
        Set<String> validCombo = getPermutation(words);
        int wordLength = words[0].length() * words.length;
        for (int i = 0; i < s.length() - wordLength; i++) {
            if (validCombo.contains(s.substring(i, i + wordLength))) {
                result.add(i);
            }
        }
        return result;
    }
}