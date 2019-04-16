package solution12;

public class HasPath {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //表示上下左右四个方向
    private int rows;
    private int cols;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] array = getMatrix(matrix);
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if (backtracking(array, str, marked, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    private char[][] getMatrix(char[] matrix){
        char[][] array = new char[rows][cols] ;
        for(int i = 0,index = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                array[i][j] = matrix[index++];
            }
        }
        return array;
    }
    private boolean backtracking(char[][] array, char[] str, boolean[][] marked, int pathLen, int r, int c){
        if (pathLen == str.length)
            return true;
        if(r < 0 || r >= rows || c < 0 || c >= cols || array[r][c] != str[pathLen] || marked[r][c]){
            return false;
        }
        marked[r][c] = true; //要先假设已经访问过
        for (int[] n : next){
            if(backtracking(array, str, marked, pathLen + 1, r + n[0], c + n[1])){
                return true;
            }
        }
        marked[r][c] = false;//如果上述循环没有返回，则说明周围没有符合条件的值，就要标记没有访问过该值
        return false;
    }
}
