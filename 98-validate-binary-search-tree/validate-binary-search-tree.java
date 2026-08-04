/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBSTHelper(TreeNode node,long lower,long upper)
    {
        if(node==null)
        {
            return true;
        }
        if(node.val>=upper || node.val<=lower)
        {
            return false;
        }
        boolean left=isValidBSTHelper(node.left,lower,node.val);
        if(!left)
        {
            return false;
        }
        return isValidBSTHelper(node.right,node.val,upper);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}