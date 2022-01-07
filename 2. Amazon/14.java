// Ques - Tree Burning

public static int minTime(Node root, int target) 
    {
        HashMap<Node,Node> map = new HashMap<>(); // to assign parent pointer
        HashMap<Node,Boolean> vis = new HashMap<>(); 
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        Node tar = null;
        while(q.size() != 0){
            Node rem = q.remove();
            if(rem.data == target) tar = rem;
            vis.put(rem,false);
            if(rem.left != null){
                q.add(rem.left);
                map.put(rem.left,rem);
            }
            if(rem.right != null){
                q.add(rem.right);
                map.put(rem.right,rem);
            }
        }
        q = new ArrayDeque<>();
        q.add(tar);
        int t = 0;
        vis.put(tar,true);
        while(q.size() != 0){
            int size = q.size();
            boolean flag = false;
            for(int i=0;i<size;i++){
                Node rem = q.remove();
                if(rem.left != null && vis.get(rem.left) == false){
                    flag = true;
                    vis.put(rem.left,true);
                    q.add(rem.left);
                }
                if(rem.right != null && vis.get(rem.right) == false){
                    flag = true;
                    vis.put(rem.right,true);
                    q.add(rem.right);
                }
                if(map.get(rem) != null && vis.get(map.get(rem)) == false){
                    flag = true;
                    vis.put(map.get(rem),true);
                    q.add(map.get(rem));
                    map.remove(rem);
                }
            }
            if(flag) t++;
        }
        
        return t;
    }