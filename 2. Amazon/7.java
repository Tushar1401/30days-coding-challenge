// Ques - First non-repeating character in a stream

public String FirstNonRepeating(String str)
    {
        Queue<Character> q = new ArrayDeque<>();
        int[] farr = new int[26];
        StringBuilder res = new StringBuilder();
        for(char ch : str.toCharArray()){
            farr[ch - 'a']++;
            if(farr[ch - 'a'] < 2) q.add(ch);
            while(q.size() != 0 && farr[q.peek() - 'a'] > 1){
                q.remove();
            }
            
            if(q.size() == 0){
                res.append('#');
            }else{
                res.append(q.peek());
            }
        }
        
        return res.toString();
    }