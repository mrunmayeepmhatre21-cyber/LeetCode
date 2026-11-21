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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store inorder values and their indices
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Start from the last index of postorder
        int[] postIndex = {postorder.length - 1};

        return construct(inorder, postorder, 0, inorder.length - 1,
                         map, postIndex);
    }

    private TreeNode construct(int[] inorder, int[] postorder,
                               int left, int right,
                               HashMap<Integer, Integer> map,
                               int[] postIndex) {

        // Base case
        if (left > right) return null;

        // Pick root from postorder (right to left)
        int value = postorder[postIndex[0]--];

        TreeNode root = new TreeNode(value);

        // Find root position in inorder
        int mid = map.get(value);

        // Construct right subtree FIRST
        root.right = construct(inorder, postorder, mid + 1, right,
                               map, postIndex);

        // Construct left subtree SECOND
        root.left = construct(inorder, postorder, left, mid - 1,
                              map, postIndex);

        return root;
    }
}
