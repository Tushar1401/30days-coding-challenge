// Ques - Print group anagrams

public List<List<String>> Anagrams(String[] string_list) {
    List<List<String>> res = new ArrayList<>();
    HashMap<HashMap<Character,Integer>,ArrayList<String>> map = new HashMap<>();
    
    for(String str : string_list){
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(char ch : str.toCharArray()){
            fmap.put(ch,fmap.getOrDefault(ch,0) + 1);
        }
        
        if(map.containsKey(fmap)){
            map.get(fmap).add(str);
        }else{
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            map.put(fmap,list);
        }
    }
    
    for(ArrayList<String> val : map.values()){
        res.add(val);
    }
    
    return res;
}