import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 한바퀴 돌면서 topping별 갯수를 체크하는 맵
        Map<Integer,Integer> map = new HashMap<>();
        for(int top : topping){
            map.put(top, map.getOrDefault(top, 0)+1);
        }
        
        // 앞부분부터 끊었을때 topping의 종류를 모으는 set
        Set<Integer> set = new HashSet<>();
        for(int top : topping){
            // top을 set에 넣고
            set.add(top);
            
            // map 갱신
            if(map.get(top) == 1){
                map.remove(top);
            } else {
                map.put(top, map.get(top)-1);
            }
            
            // map.keySet()과 set의 사이즈가 같으면 공평하게 나눈 케이스
            if(map.keySet().size() == set.size()){
                ++answer;
            } else if(map.keySet().size() < set.size()){
                // set이 크다면 앞부분이 더 커져서 더이상 볼 필요가 없음
                break;
            }
        }
        return answer;
    }
}