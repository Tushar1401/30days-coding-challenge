// Ques - Connect Nodes at Same Level

public void connect(Node root)
    {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(q.size() != 0){
            Node rem = q.remove();
                
            if(rem != null){
                if(q.size() != 0){
                    rem.nextRight = q.peek();
                }
                    
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);
            }else if(q.size() != 0){
                q.add(null);
            }
        }
    }