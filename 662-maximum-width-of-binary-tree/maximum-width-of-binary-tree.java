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
    class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode n, int i){
            node = n;
            index = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , 1));
        int maxwidth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;
            int first =0; int last =0;

            for(int i=0;i<size;i++){
                Pair p = q.poll();
                int curr = p.index - min;

                if(i == 0) first = curr;
                if(i == size-1)last = curr;

                if(p.node.left != null)
                q.add(new Pair(p.node.left , curr*2));
                if(p.node.right != null)
                q.add(new Pair(p.node.right, curr*2 + 1));
            }
            maxwidth = Math.max(maxwidth , last - first+1);
        }
        return maxwidth;
    }
}