import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        String[][] map = new String[51][51];
        int parent[][] = new int[51][51];
        for(int r = 1; r<51;++r){
            for(int c = 1; c<51;++c){
                map[r][c] = "";
                parent[r][c] = r*100+c;
            }
        }
        List<String> answer = new ArrayList<>();
        for(String command : commands){
            String[] cs = command.split(" ");
            if(cs[0].equals("UPDATE")){
                if(cs.length == 4){
                    int row = Integer.parseInt(cs[1]);
                    int col = Integer.parseInt(cs[2]);
                    String value = cs[3];
                    int parentNum = parent[row][col];
                    map[parentNum/100][parentNum%100] = value;
                } else {
                    String value1 = cs[1];
                    String value2 = cs[2];
                    for(int r = 1; r<51;++r){
                        for(int c = 1; c<51;++c){
                            if(map[r][c].equals(value1)){
                                map[r][c] = value2;
                            }
                        }
                    }
                }
            } else if (cs[0].equals("MERGE")){
                int r1 = Integer.parseInt(cs[1]);
                int c1 = Integer.parseInt(cs[2]);
                int r2 = Integer.parseInt(cs[3]);
                int c2 = Integer.parseInt(cs[4]);
                if(map[r1][c1].equals("")){
                    map[r1][c1] = map[parent[r2][c2]/100][parent[r2][c2]%100];
                }
                int parentNum = parent[r2][c2];
                for(int r = 1; r<51;++r){
                    for(int c = 1; c<51;++c){
                        if(parent[r][c] == parentNum){
                            parent[r][c] = parent[r1][c1];
                        }
                    }
                }
            } else if (cs[0].equals("UNMERGE")){
                int row = Integer.parseInt(cs[1]);
                int col = Integer.parseInt(cs[2]);
                int parentNum = parent[row][col];
                map[row][col] = map[parentNum/100][parentNum%100];
                parent[row][col] = row*100+col;
                for(int r = 1; r<51;++r){
                    for(int c = 1; c<51;++c){
                        if(parent[r][c] == parentNum){
                            if((r != row)||(c!=col)){
                                map[r][c] = "";
                                parent[r][c] = r*100+c;
                            }
                        }
                    }
                }
            } else if (cs[0].equals("PRINT")){
                int row = Integer.parseInt(cs[1]);
                int col = Integer.parseInt(cs[2]);
                int parentNum = parent[row][col];
                String ans = map[parentNum/100][parentNum%100];
                if(ans.equals("")){
                    answer.add("EMPTY");
                } else {
                    answer.add(ans);
                }
            }
        }
        String[] ans = new String[answer.size()];
        for(int i = 0; i<answer.size();++i){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}