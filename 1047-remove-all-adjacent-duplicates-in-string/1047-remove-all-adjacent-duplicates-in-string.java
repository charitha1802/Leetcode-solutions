class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        String res = "";
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            res= res+st.pop();
        }
        String f = "";
        for(int i=res.length()-1;i>=0;i--){
            f = f+res.charAt(i);
        }
        return f;
    }
}