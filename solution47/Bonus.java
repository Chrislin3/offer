package solution47;

/**
 * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，
 * 游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，
 * 他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的礼物小东都能拿到，
 * 请设计一个算法使小东拿到价值最高的礼物。
 *
 * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，保证每个礼物价值大于100小于1000。
 */
public class Bonus {
    public static int getMost(int[][] board) {
        return process(board, 0, 0);
    }

    private static int process(int[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return arr[row][col];
        } else if (row == arr.length - 1) {
            return arr[row][col] + process(arr, row, col + 1);
        } else if (col == arr[0].length - 1) {
            return arr[row][col] + process(arr, row + 1, col);
        } else {
            return arr[row][col] + Math.max(process(arr, row + 1, col), process(arr, row, col + 1));
        }
    }

    public static int getMost2(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = board[rows - 1][cols - 1];

        for (int i = rows - 1; i > 0; i--) {
            dp[i-1][cols - 1] = dp[i][cols - 1] + board[i - 1][cols - 1];
        }

        for (int i = cols - 1; i > 0; i--) {
            dp[rows - 1][i-1] = dp[rows - 1][i] + board[rows - 1][i - 1];
        }
        for (int i = rows - 1; i > 0; i--) {
            for (int j = cols - 1; j > 0; j--) {
                dp[i - 1][j - 1] = Math.max(dp[i][j - 1], dp[i - 1][j]) + board[i - 1][j - 1];
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.print(getMost2(m));
    }
}
