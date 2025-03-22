import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static StringBuilder sb;
    static boolean isSolved;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        sb = new StringBuilder();
        isSolved = false;
        checkMap(0,0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void checkMap(int r, int c) {
        if (isSolved) {
            return;
        }
        if (r>=9){
            isSolved = true;
            return;
        }
        if (c>=9){
            checkMap(r+1,0);
            return;
        }
        if (map[r][c]!=0){
            checkMap(r,c+1);
            return;
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= 9; i++) {
                set.add(i);
            }
            for (int i = 0; i < 9; i++) {
                if (set.contains(map[r][i])){
                    set.remove(map[r][i]);
                }
                if (set.contains(map[i][c])){
                    set.remove(map[i][c]);
                }
            }
            if (r<3){
                if (c<3){
                    for (int row = 0; row<3; ++row){
                        for (int col = 0; col<3; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                } else if (c<6){
                    for (int row = 0; row<3; ++row){
                        for (int col = 3; col<6; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                } else {
                    for (int row = 0; row<3; ++row){
                        for (int col = 6; col<9; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                }
            } else if (r<6){
                if (c<3){
                    for (int row = 3; row<6; ++row){
                        for (int col = 0; col<3; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                } else if (c<6){
                    for (int row = 3; row<6; ++row){
                        for (int col = 3; col<6; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                } else {
                    for (int row = 3; row<6; ++row){
                        for (int col = 6; col<9; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                }
            } else {
                if (c<3){
                    for (int row = 6; row<9; ++row){
                        for (int col = 0; col<3; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                } else if (c<6){
                    for (int row = 6; row<9; ++row){
                        for (int col = 3; col<6; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                } else {
                    for (int row = 6; row<9; ++row){
                        for (int col = 6; col<9; ++col){
                            if (set.contains(map[row][col])){
                                set.remove(map[row][col]);
                            }
                        }
                    }
                }
            }
            if (set.size()==0){
                return;
            } else {
                for (int i = 1 ; i<=9 ; ++i){
                    if (set.contains(i)){
                        map[r][c] = i;
                        checkMap(r,c+1);
                        if (isSolved) return;
                        map[r][c] = 0;
                    }
                }
            }
        }
    }
}
