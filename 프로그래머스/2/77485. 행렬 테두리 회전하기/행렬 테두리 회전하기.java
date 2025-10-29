class Solution {
    static int[][] board;
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        board = new int[rows][columns];
        int idx = 1;
        for(int i = 0; i<rows;++i){
            for(int j = 0 ; j<columns; ++j){
                board[i][j] = idx++;
            }
        }
        
        for(int i = 0; i<queries.length;++i){
            answer[i] = moveBoard(queries[i]);
        }
        return answer;
    }

    private static int moveBoard(int[] arr){
        int num = 987654321;
        int row1 = arr[0]-1;
        int col1 = arr[1]-1;
        int row2 = arr[2]-1;
        int col2 = arr[3]-1;
        int temp = board[row1][col1];
        
        // 왼쪽
        for(int i = row1; i<row2; ++i){
            board[i][col1] = board[i+1][col1];
            num = Math.min(num, board[i][col1]);
        }
        
        // 아래
        for(int i = col1; i<col2; ++i){
            board[row2][i] = board[row2][i+1];
            num = Math.min(num, board[row2][i]);
        }
        
        // 오른쪽
        for(int i = row2; i>row1; --i){
            board[i][col2] = board[i-1][col2];
            num = Math.min(num, board[i][col2]);
        }
        
        // 위
        for(int i = col2; i>col1+1 ; --i){
            board[row1][i] = board[row1][i-1];
            num = Math.min(num, board[row1][i]);
        }
        board[row1][col1+1] = temp;
        num = Math.min(num, temp);
        
        return num;
    }
}