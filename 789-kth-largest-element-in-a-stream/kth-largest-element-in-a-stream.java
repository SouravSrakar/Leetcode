class KthLargest {

    class TreeNode {
        int val;
        int count;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.count = 1;
        }
    }

    TreeNode root;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            root = insert(root, num);
        }
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null)
            return new TreeNode(val);

        if (val < node.val)
            node.left = insert(node.left, val);
        else
            node.right = insert(node.right, val);

        node.count = 1 + size(node.left) + size(node.right);

        return node;
    }

    private int size(TreeNode node) {
        return node == null ? 0 : node.count;
    }

    private int kthLargest(TreeNode node, int k) {

        int rightSize = size(node.right);

        if (k == rightSize + 1)
            return node.val;

        if (k <= rightSize)
            return kthLargest(node.right, k);

        return kthLargest(node.left, k - rightSize - 1);
    }

    public int add(int val) {
        root = insert(root, val);
        return kthLargest(root, k);
    }
}