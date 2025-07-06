package practice;

public class P22MaxDepth {
    /*
    No.104 maximum-depth-of-binary-tree
    最大深度，显然递归，等于左右子树的最大深度+1
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return depth;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        int res = new P22MaxDepth().maxDepth(t1);
        System.out.println(res);
    }
}
