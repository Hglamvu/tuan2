import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class demo {
    public List<String> wordBreak(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        backtrack(s, wordSet, result, new StringBuilder(), 0);
        return result;
        }
    private void backtrack(String s, Set<String> wordSet, List<String> result, StringBuilder currentSentence, int start){
        //kiểm tra đã duyệt hết tệp s chưa
        if (start == s.length()){
            result.add(currentSentence.toString().trim());
            //nếu đã duyệt hết, hàm sẽ kết thúc và thêm câu hiện tại vào result
        }
        for(int end = start+1; end<= s.length(); end++){
            //Tạo ra một từ mới từ chuỗi s
            String word = s.substring(start,end);
            //nếu từ đó có trong wordDict
            if(wordSet.contains(word)){
                int lengthBeforeAddingWord = s.length();
                //Nếu có sẽ thêm vào currentSentence và tiếp tục vòng lặp
                currentSentence.append(word).append(" ");
                backtrack(s, wordSet, result, currentSentence, end);
                currentSentence.setLength(lengthBeforeAddingWord);
            }
        }
    }


    public static void main(String args[]){
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        WordBreak wordbreak = new WordBreak();
        List<String> sentences = wordbreak.wordBreak(s,wordDict);

        for(String sentence: sentences){
            System.out.println(sentence);
        }
    }
}
