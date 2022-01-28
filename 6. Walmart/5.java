// Ques - Transform to sum tree

public void toSumTree(Node root){
    helper(root);
}

public int helper(Node root){
   if(root == null) return 0;
   if(root.left == null && root.right == null){
       int old = root.data;
       root.data = 0;
       return old;
   }
   
   int ls = helper(root.left);
   int rs = helper(root.right);
   int old = root.data;
   root.data = ls + rs;
   return old + root.data;
}