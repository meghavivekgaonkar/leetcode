package com.problem.binarytree;

public class SearchInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        
    }
 

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        TreeNode root = new TreeNode(4,left ,new TreeNode(7));
        int val = 2;

    }
    
}
