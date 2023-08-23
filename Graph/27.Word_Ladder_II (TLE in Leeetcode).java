import java.util.*;

class Word_ladder_II_Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> words = new HashSet<>();

        for(int i=0;i<wordList.size();i++) words.add(wordList.get(i));

        Queue<List<String>> q = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        List<String> removeStr = new ArrayList<>();
        ls.add(beginWord);
        removeStr.add(beginWord);
        q.add(ls);
        int level = 0;

        while(!q.isEmpty()){
          
            ls = q.peek(); 
            q.poll();

            if(ls.size() > level){
                level++;
                for(String w: removeStr) words.remove(w);
                removeStr.clear();
            }

            String str = ls.get(ls.size()-1);
            if(str.equals(endWord)){
                if(res.size() == 0) res.add(ls);
                else if(res.get(0).size() == ls.size()) res.add(ls);
            }

            for(int j=0;j<str.length();j++){
                for(char ch='a'; ch<='z';ch++){
                    char[] arr = str.toCharArray();
                    arr[j] = ch;
                    String generatedStr = new String(arr);

                    if(words.contains(generatedStr)){
                        ls.add(generatedStr);
                        List<String> temp = new ArrayList<>(ls);
                        q.add(temp);
                        removeStr.add(generatedStr);
                        ls.remove(ls.size()-1);
                    }
                }   
            }                        
            
        }
        return res;
    }
}

public class Word_Ladder_II {
    public static void main(String[] args){

        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list = Arrays.asList(wordList);
        String beginWord = "hit", endWord = "cog";
        
        Word_ladder_II_Solution solution = new Word_ladder_II_Solution();
        System.out.println(solution.findLadders(beginWord, endWord, list));
    }
}
