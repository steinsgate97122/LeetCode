package practice;

public class P23BST {
    /*
    No.110 balanced-binary-tree
    判断是否是平衡二叉树，定义是针对树的所有节点，其左右二叉树的高度相差不超过1
    如果左右子树都是平衡二叉树，其高度相差还是有可能大于1，所以除了需要左右二叉树都是平衡二叉树之外，两个树的高度还不能超过1
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalanced(root.left) && isBalanced(root.right)) {
            return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        }
        return false;
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
//        t1.left = t3;
        boolean res = new P23BST().isBalanced(t1);
        System.out.println(res);
    }
}
