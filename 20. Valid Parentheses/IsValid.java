import java.util.*;

public class IsValid {
    public boolean isValid(String s) {
        // the string length is odd, it cannot be valid
        if (s.length() % 2 != 0) {
            return false;
        }
        // Use a stack to store the expected closing brackets
        Stack<Character> st = new Stack<>();

        // Convert the string to a character array for iteration
        for (char ch: s.toCharArray()) {
            // if ch is left bracket, push the corresponding closing bracket
            if (ch == '(') {
                st.push(')');
            } else if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            }
            // If a right bracket is found, chech the match
            else if (st.isEmpty() || ch != st.peek()) {
                // Return false if the stack is empty or no match is found
                return false;
            }
            else st.pop();
        }
        // Return true if all brackets are matched
        return st.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid.isValid(s));
    }
}
