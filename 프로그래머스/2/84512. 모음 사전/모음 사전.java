import java.util.*;

class Solution {
    static Map<String, Integer> Dictionary;
    static char[] alpabet = {'A','E','I','O','U'};
    public static int solution(String word) {
        Dictionary = new HashMap<>();
        char[] list = new char[5];
        makeDictionary(0, list);
        return Dictionary.get(word);
    }
    
    private static void makeDictionary(int len, char[] list){
        if(len == 5){
            return;
        }
        
        for(int i = 0; i<5; ++i){
            list[len] = alpabet[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<len+1; ++j){
                sb.append(list[j]);
            }
            Dictionary.put(sb.toString(), Dictionary.size()+1);
            makeDictionary(len+1, list);
        }
    }
}