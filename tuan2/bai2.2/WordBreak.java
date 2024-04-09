import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        backtrack(s, wordSet, result, new StringBuilder(), 0);
        return result;
    }
    private void backtrack(String s, Set<String> wordSet, List<String> result, StringBuilder currentSentence, int start) {
        if (start == s.length()) {
            result.add(currentSentence.toString().trim());
            return;
        }
        for (int a = start + 1; a <= s.length(); a++) {
            String word = s.substring(start, a);
            if (wordSet.contains(word)) {
                int lengthBeforeAddingWord = currentSentence.length();
                currentSentence.append(word).append(" ");
                backtrack(s, wordSet, result, currentSentence, a);
                currentSentence.setLength(lengthBeforeAddingWord); // Backtrack by removing the last word
            }
        }
    }
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        WordBreak wordBreak = new WordBreak();
        List<String> sentences = wordBreak.wordBreak(s, wordDict);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
