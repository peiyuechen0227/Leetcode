import java.util.*;
public class removeDuplicates {
    public String removeDuplicates(String s) {
        // If s is null ,return s
        if (s == null) {
            return s;
        }
        // Using a stack to store the elements
        Deque<Character> stack = new ArrayDeque<>();

        // Checking if the adjacent elements are equal by iteration
        for (Character ch: s.toCharArray()) {
            // If the current element matches the top of the stack,pop the stack
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            } else stack.push(ch); // Otherwise, push the character into the stack
        }
        // Build the result string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // reverse the string
        String result = sb.reverse().toString();

        return result;
    }

    public static void main(String args[]) {
        removeDuplicates r = new removeDuplicates();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(r.removeDuplicates(s));
    }
}
