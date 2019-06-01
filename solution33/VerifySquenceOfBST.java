package solution33;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 假设输入的数组的任意两个数字都互不相同。
 * 例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。
 * 2
 * 1    3
 */
public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int root = sequence[last];
        int curIndex = first;
        while (curIndex < last && root > sequence[curIndex]) {
            curIndex++;
        }
        for (int i = curIndex; i < last; i++) {
            if (root > sequence[i]) {
                return false;
            }
        }
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last);
    }
}
