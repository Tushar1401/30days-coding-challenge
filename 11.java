// Ques - Serialize and Deserialize a Binary Tree 

    public void serialize(Node root, ArrayList<Integer> A) 
	{
	    ArrayList<Integer> res = helper1(root);
	    for(int val : res){
	        A.add(val);
	    }
	}
	public ArrayList<Integer> helper1(Node root){
	    if(root == null) return new ArrayList<Integer>();
	    if(root.left == null && root.right == null && root != null){
	        ArrayList<Integer> bres = new ArrayList<>();
	        bres.add(root.data);
	        return bres;
	    }
	    ArrayList<Integer> left = helper1(root.left);
	    ArrayList<Integer> right = helper1(root.right);
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    for(int val : left){
	        res.add(val);
	    }
	    res.add(root.data);
	    for(int val : right){
	        res.add(val);
	    }
	    
	    return res;
	}
	
    public Node deSerialize(ArrayList<Integer> A)
    {
        Node root = new Node(0);
        Node temp = root;
        for(int i=0; i<A.size();i++){
            temp.right = new Node(A.get(i));
            temp = temp.right; 
        }
        return root.right; 
    }