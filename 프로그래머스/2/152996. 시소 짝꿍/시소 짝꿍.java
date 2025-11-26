import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        long answer = 0;
        for(int w : weights){
            double a = w*1.0; // 1대1 비율
            double b = (w*2.0)/3.0; // 2대3 비율
            double c = (w*2.0)/4.0; // 2대4 비율
            double d = (w*3.0)/4.0; // 3대4 비율
            
            if(map.containsKey(a)){
                answer += map.get(a);
            }
            if(map.containsKey(b)){
                answer += map.get(b);
            }
            if(map.containsKey(c)){
                answer += map.get(c);
            }
            if(map.containsKey(d)){
                answer += map.get(d);
            }
            
            map.put(a, map.getOrDefault(a,0)+1);
        }
        
        return answer;
    }
}