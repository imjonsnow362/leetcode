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
class Solution{
    public int maxDepth(TreeNode root){
        //returning the value from function height from line 22 
        return height(root);
    }
    //function
   private int height(TreeNode root){
       //if my root is at null I just need to return 0 
       if(root == null)
           return 0;
       //I will make a call here to the left child and the right child
       //I will call the function height and use root.left/right to go to the desired child
       //The children are present one level down so I am adding 1 to the answer 
        int leftAns = 1 + height(root.left);
        int rightAns= 1 + height(root.right);
       //Return maximum integer value of both of them 
        return Math.max(leftAns, rightAns);
   }
}
        