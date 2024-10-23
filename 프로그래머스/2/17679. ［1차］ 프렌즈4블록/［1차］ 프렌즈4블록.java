class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] blocks = new char[m][n];
        for(int i = 0; i < m; i ++) {
            blocks[i] = board[i].toCharArray();
        }
        while(true) {
            boolean flag = false;
            boolean[][] visited = new boolean[m][n];

            for(int i = 0; i < m-1; i ++) {
                for(int j = 0; j < n-1; j ++) {
                    char current = blocks[i][j];
                    if(current == '@') {
                        continue;
                    }
                    if(blocks[i][j+1]==current && blocks[i+1][j]==current && blocks[i+1][j+1]==current) {
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            if(!flag) {
                break;
            }
            
            for(int i = 0; i < m; i ++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j]) {
                        blocks[i][j] = '@';
                        answer ++;
                    }
                }
            }
            
            for(int j = 0; j < n; j ++) {
                for(int i = m-1; i >= 0; i --) {
                    if(blocks[i][j] == '@') {
                        for(int k = i-1; k >=0; k --) {
                            if(blocks[k][j] != '@') {
                                blocks[i][j] = blocks[k][j];
                                blocks[k][j] = '@';
                                break; 
                            }
                        }
                    }
                }
            }
        }
           
        return answer;
    }
}