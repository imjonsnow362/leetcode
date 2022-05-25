/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution{
    public int maxDepth(Node root){
        //return value from function height on line 25
        return height(root);
    }
    private int height(Node root){
        //base condition will always be same 
        if(root == null)
            return 0;
        //I have to iterate over all of its children 
        //So I will iterate over the given list in the input <<Reference from line 13>>
        int ans = 0;  //for comparing I am using ans variable 
        for(Node currentChild: root.children)
            //Max depth we are processing currentChild 
            ans = Math.max(ans, height(currentChild));
        //we did not add 1 in the depth function so we will add it in the return statement 
        return 1 + ans;
    }
}