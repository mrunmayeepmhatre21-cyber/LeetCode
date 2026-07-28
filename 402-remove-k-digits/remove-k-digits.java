class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // remove remaining from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // build result
        StringBuilder sb = new StringBuilder();
        for (char d : stack) sb.append(d);
        
        // strip leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
