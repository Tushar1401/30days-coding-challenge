// Ques - Delete N nodes after M nodes of a linked list 

static void linkdelete(Node head, int M, int N)
    {
        Node temp = head;
        int m = 1;
        while(temp != null){
            if(m == M){
                Node curr = temp;
                int counter = 0;
                while(temp != null && counter != N){
                    temp = temp.next;
                    counter++;
                }
                curr.next = temp == null ? null : temp.next;
                temp = temp == null ? null : temp.next;
                m = 1;
            }else{
                temp = temp == null ? null : temp.next;   
                m++;
            }
        }
    }