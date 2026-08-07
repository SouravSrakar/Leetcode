/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pval=p.val;
        int qval=q.val;
        TreeNode curr=root;
        while(curr!=null)
        {
            if(pval>curr.val && qval>curr.val)
            {
                curr=curr.right;
            }
            else if(pval<curr.val && qval<curr.val)
            {
                curr=curr.left;
            }
            else
            {
                return curr;
            }
        }
        return null;
    }
}