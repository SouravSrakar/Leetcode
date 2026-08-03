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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent=null,
        curr=root;
        while(curr!=null && curr.val!=key)
        {
            parent=curr;
            if(key<curr.val)
            {
                curr=curr.left;
            }
            else
            {
                curr=curr.right;
            }
        }
        if(curr==null)
        {
            return root;
        }
        if(curr.left!=null && curr.right!=null)
        {
            TreeNode s=curr.right;
            TreeNode sp=curr;
            while(s.left!=null)
            {
                sp=s;
                s=s.left;
            }
            curr.val=s.val;
            curr=s;
            parent=sp;
        }
        if(curr.left==null && curr.right==null)
        {
            if(parent==null)
            {
                return null;
            }
            if(curr==parent.right)
            {
                parent.right=null;
            }
            else
            {
                parent.left=null;
            }
        }
        if(curr.left!=null || curr.right!=null)
        {
            if(parent==null)
            {
                return curr.left!=null ? curr.left : curr.right;
            }
            if(curr==parent.right)
            {
                parent.right=curr.left!=null ? curr.left : curr.right;
            }
            if(curr==parent.left)
            {
                parent.left=curr.left!=null ? curr.left : curr.right;
            }
        }
        return root;

    }
}