package com.problem.binarytree;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivaluedTree(root,root.val);
    }

    //recurssively check if the root node has the same value
    //update the root node to left and right 
    public boolean isUnivaluedTree(TreeNode root, int val){

        if(root==null){
             return true;
        }
        return root.val==val && isUnivaluedTree(root.left, val) && isUnivaluedTree(root.right,val);
      
    }
}
