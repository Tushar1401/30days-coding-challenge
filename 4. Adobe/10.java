// Ques - Elections

public static String[] winner(String arr[], int n)
    {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String str : arr) map.put(str,map.getOrDefault(str,0) + 1);
        
        String[] res = new String[2];
        
        int max = 0;
        String s = "";
        for(String key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                s = key;
            }else if(map.get(key) == max){
                if(key.compareTo(s) < 0){
                    s = key;
                }
            }
        }
        
        res[0] = s;
        res[1] = max + "";
        return res;
    }