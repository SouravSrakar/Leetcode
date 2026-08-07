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
    public TreeNode sortedArrayToBstHelper(int[] nums,int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        int mid=start+(end-start)/2;
        int nodeval=nums[mid];
        TreeNode node=new TreeNode(nodeval);
        node.left=sortedArrayToBstHelper(nums,start,mid-1);
        node.right=sortedArrayToBstHelper(nums,mid+1,end);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=sortedArrayToBstHelper(nums,0,nums.length-1);
        return root;
    }
}