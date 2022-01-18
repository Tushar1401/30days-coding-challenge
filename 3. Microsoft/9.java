// Ques - Count Number of SubTrees having given Sum 

int count = 0;
    int countSubtreesWithSumX(Node root, int X)
    {
        helper(root,X);
        return count;
    }
    
    int helper(Node root, int target){
        if(root == null){
            return 0;
        }
        
        int sum = helper(root.left,target) + helper(root.right,target) + root.data;
        if(sum == target){
            count++;
        }
        return sum;
    }