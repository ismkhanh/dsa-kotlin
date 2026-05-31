class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                else if (map.get(c) != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }
}
