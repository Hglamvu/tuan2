import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class WordBreak {
    //tạo các câu từ chuỗi s và danh sách từ điển wordDict
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Chuyển danh sách từ điển thành một tập hợp 
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        // Gọi phương thức backtrack để tạo câu từ s
        backtrack(s, wordSet, result, new StringBuilder(), 0);
        return result;
    }
    private void backtrack(String s, Set<String> wordSet, List<String> result, StringBuilder currentSentence, int start) {
        //start đến cuối chuỗi s --> tạo được một câu hoàn chỉnh
        if (start == s.length()) {
            result.add(currentSentence.toString().trim());
            return;
            //kết thúc đệ quy 
        }
        // Duyệt qua tất cả các từ có thể tạo từ start đến cuối chuỗi s
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end); // Lấy từ vị trí start đến end
            // Nếu từ đó có trong từ điển, tiếp tục tạo câu từ phần còn lại của chuỗi 
            if (wordSet.contains(word)) {
                // Lưu độ dài câu trước khi thêm từ
                int lengthBeforeAddingWord = currentSentence.length();
                // Thêm từ vào câu hiện tại
                currentSentence.append(word).append(" ");
                // Gọi đệ quy từ vị trí end
                backtrack(s, wordSet, result, currentSentence, a);
                currentSentence.setLength(lengthBeforeAddingWord); 
            
            }
        }
    }
    public static void main(String[] args) {
        // Chuỗi đầu vào và danh sách từ điển
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        //Tạo đối tượng WordBreak và gọi phương thức wordBreak để tạo các câu
        WordBreak wordBreak = new WordBreak();
        List<String> sentences = wordBreak.wordBreak(s, wordDict);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
