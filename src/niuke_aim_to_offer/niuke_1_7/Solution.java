package niuke_aim_to_offer.niuke_1_7;


/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 输入描述:
 二叉树的镜像定义：源二叉树:
      8
    /  \
   6   10
  / \  / \
 5  7 9 11
 镜像二叉树:
       8
     /  \
    10   6
   / \  / \
  11 9 7  5
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;

        printTreeNode(treeNode1);
        new Solution().Mirror(treeNode1);
        printTreeNode(treeNode1);
    }

    private static void printTreeNode(TreeNode treeNode1) {
        System.out.println(treeNode1.toString());
        if (treeNode1.left!=null){
            printTreeNode(treeNode1.left);
        }
        if (treeNode1.right!=null){
            printTreeNode(treeNode1.right);
        }


    }


    public void Mirror(TreeNode root) {

            if(root==null)
                return;
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
            Mirror(root.left);
            Mirror(root.right);




    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    @Override
    public String toString() {

        String leftStr = "null";
        String rightStr = "null";
        if (left!=null)
            leftStr = left.val +"";
        if (right!=null)
            rightStr = right.val +"";
        return "val :" + val + " left: "+leftStr + " right: " + rightStr;
    }
}