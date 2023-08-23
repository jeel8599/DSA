import java.util.*;

class WordPair{
    String first;
    int second;
    
    public WordPair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Word_ladder_Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> words = new HashSet<>();

        for(int i=0;i<wordList.size();i++) words.add(wordList.get(i));

        Queue<WordPair> q = new LinkedList<>();
        q.add(new WordPair(beginWord,1));

        while(!q.isEmpty()){
            String str = q.peek().first;
            int level = q.peek().second;
            q.poll();

            if(str.equals(endWord)) return level;
            
            for(int i=0;i<str.length();i++){       
                for(char ch='a'; ch<='z';ch++){
                    char[] arr = str.toCharArray();
                    arr[i] = ch;
                    String generatedStr = new String(arr);

                    if(words.contains(generatedStr)){
                        q.add(new WordPair(generatedStr,level+1));
                        words.remove(generatedStr);
                    }
                }
            }
        }
        return 0;
    }
}

public class Word_ladder_I {
    public static void main(String[] args){

        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list = Arrays.asList(wordList);
        String beginWord = "hit", endWord = "cog";
        
        Word_ladder_Solution solution = new Word_ladder_Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, list));
    }
}
