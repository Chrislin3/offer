package solution29;

import java.util.ArrayList;

public class PrintMatrix {
    private ArrayList<Integer> result=new ArrayList<>();

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


    public ArrayList<Integer> printMatrix2(int[][] matrix) {
        int LR = 0;
        int LC = 0;
        int RR = matrix.length - 1;
        int RC = matrix[0].length - 1;
        while (LR <= RR && LC <= RC) {
            printMatrix2(matrix, LR++, LC++, RR--, RC--);
        }
        return result;
    }

    private void printMatrix2(int[][] matrix, int LR, int LC, int RR, int RC) {

        if (LC == RC && LR == RR) {
            result.add(matrix[LR][LC]);
        } else if (LC == RC) {
            for (int i = LR; i <= RR; i++) {
                result.add(matrix[i][LC]);
            }
        } else if (LR == RR) {
            for (int i = LC; i <= RC; i++) {
                result.add(matrix[LR][i]);
            }
        } else {
            for (int i = LC; i < RC; i++) {
                result.add(matrix[LR][i]);
            }
            for (int i = LR; i < RR; i++) {
                result.add(matrix[i][RC]);
            }

            for (int i = RC; i > LC; i--) {
                result.add(matrix[RR][i]);
            }

            for (int i = RR; i > LR; i--) {
                result.add(matrix[i][LC]);
            }
        }




    }

    public static void main(String[] args) {
        ArrayList<Integer> result;
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        PrintMatrix printMatrix = new PrintMatrix();
        result = printMatrix.printMatrix2(arr);
        for (int val : result) {
            System.out.print(val);
            System.out.print(" ");
        }
    }
}
