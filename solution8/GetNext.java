package solution8;

/**
 * 题目：
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

/**思路：
 * A.该节点有右子树，那么下一个节点就是右子树的最左边的一个节点（发现了吗，这里有while循环，要一直找左节点）
 * B.该节点没有右子树，如果它是其父节点的左节点，那么它的父节点就是下一个节点
 * C.该节点没有右子树并且是其父节点的右节点，那就一直找它的父节点，直到找到一个是它父节点左节点的节点，这个父节点就是下一个节点
 * B和C都是涉及找父节点的，可以合成一个问题，同时，找父节点的过程也是在while循环，要一直找父节点。
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                } else {
                    pNode = pNode.next;
                }
            }

        }

        return null;

    }
}
