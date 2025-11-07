import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int cnt = 0;
        for(String rec : record){
            StringTokenizer st = new StringTokenizer(rec);
            String move = st.nextToken();
            String uuid = st.nextToken();
            String name;
            if(!move.equals("Leave")){
                name = st.nextToken();
                map.put(uuid, name);    
            }
            if(!move.equals("Change")){
                ++cnt;
            }
        }
        int idx = 0;
        String[] answer = new String[cnt];
        for(String rec : record){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(rec);
            String move = st.nextToken();
            String uuid = st.nextToken();
            if(move.equals("Enter")){
                sb.append(map.get(uuid)).append("님이 들어왔습니다.");
                answer[idx++] = sb.toString();
            } else if(move.equals("Leave")){
                sb.append(map.get(uuid)).append("님이 나갔습니다.");
                answer[idx++] = sb.toString();
            }
        }
        return answer;
    }
}