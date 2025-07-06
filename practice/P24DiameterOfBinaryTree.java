package practice;

public class P24DiameterOfBinaryTree {
    /*
    No.543 diameter-of-binary-tree
    返回二叉树的直径，比如下面的例子中，最长的是6 4 2 5 7这条路径，对应的边数为4
                 1
               /
              2
             / \
            4   5
           /     \
          6       7
     所以root节点未必参与到最长边内，直接递归直径也没什么用
     换个角度考虑，单节点6的直径为0，一旦有个子节点，直径最少也是1，2个子节点直径最少就是2了
     所以当前节点参与的直径最大值与左右子树的最大深度直接相关，不过当前节点未必参与到最终结果中
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameterWithRoot = maxDepth(root.left) + maxDepth(root.right);
        int diameterWithoutRoot = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(diameterWithoutRoot, diameterWithRoot);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t1.left = t3;
        int res = new P24DiameterOfBinaryTree().diameterOfBinaryTree(t1);
        System.out.println(res);
    }
}
