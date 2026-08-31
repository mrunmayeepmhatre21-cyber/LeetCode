class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";

        HashMap<Character,Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        HashMap<Character,Integer> window = new HashMap<>();
        int have=0;//how many freq matched
        int left=0;//traverse
        int start=0;//to know where current min window start 
        int minlen = Integer.MAX_VALUE;//latest minlen
        int needCount = need.size();//how much freq left

        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);

           if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }
            while(have == needCount){
                if(right-left+1<minlen){
                    minlen = right-left+1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                if(need.containsKey(leftChar) && window.get(leftChar)<need.get(leftChar)){
                    have--;
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start,start+minlen);
    }
}