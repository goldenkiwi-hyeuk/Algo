import java.util.*;

class Solution {
    static Map<Integer, Integer> child;
    static int[] arr;
    
    public static int solution(String skill, String[] skill_trees) {
        arr = new int[26];
        child = new HashMap<>();
        for(int i = 1;  i<skill.length(); ++i){
            int before = skill.charAt(i-1) - 65;
            int now = skill.charAt(i) - 65;
            child.put(before, now);
            ++arr[now];
        }
        
        int answer = 0;
        
        for(String skill_tree : skill_trees){
            boolean isok = checkSkillTree(skill_tree);
            if(isok){
                ++answer;
            }
        }
        return answer;
    }
    
    private static boolean checkSkillTree(String s){
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        for(int i = 0; i<s.length();++i){
            int now = s.charAt(i)-65;
            if(arr2[now]!=0){
                return false;
            } else {
                if(child.containsKey(now)){
                    --arr2[child.get(now)];
                }
            }
        }
        return true;
    }
}