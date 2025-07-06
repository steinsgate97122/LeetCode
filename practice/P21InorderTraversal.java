package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P21InorderTraversal {
    /*
    No.94 binary-tree-inorder-traversal
    递归算法很简单，怎么用非递归实现？中序遍历就是先左，然后中，最后右
    对于每个节点，先要处理左子树，那么这个节点放到栈里面
    从栈里面放出来的元素，都是左子树已经处理完的，那么先处理自己，然后处理右子树即可
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null && cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (cur == null) {
                cur = stack.pop();
            }
            // cur左子树已经处理完毕
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        List<Integer> res = new P21InorderTraversal().inorderTraversal(t1);
        System.out.println(res);
    }
}
