package solution29;

import java.util.ArrayList;

public class PrintMatrix {
    private ArrayList<Integer> result;

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int LR = 0;
        int LC = 0;
        int RR = matrix.length - 1;
        int RC = matrix[0].length - 1;
        while (LR <= RR && LC <= RC) {
            printMatrix(matrix, LR++, LC++, RR--, RC--);
        }
        return result;
    }

    private void printMatrix(int[][] matrix, int LR, int LC, int RR, int RC) {
        if (LR == RR) {
            for (int i = LC; i <= RC; i++) {
                result.add(matrix[LR][i]);
            }
        } else if (LC == RC) {
            for (int i = LR; i <= RR; i++) {
                result.add(matrix[i][RC]);
            }
        } else {
            int curR = LR;
            int curC = LC;
            while (curC != RC) {
                result.add(matrix[LR][curC++]);
            }
            while (curR != RR) {
                result.add(matrix[curR++][RC]);
            }
            while (curC != LC) {
                result.add(matrix[RR][curC--]);
            }
            while (curR != LR) {
                result.add(matrix[curR--][LC]);
            }
        }

    }
}
