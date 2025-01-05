import java.util.*;
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        // Use a stack to store the numbers during evaluation
        Deque<Integer> stack = new ArrayDeque<>();

        // Iterate the tokens in the expression
        for (String s: tokens) {
            // if the token is an operation, pop two numbers of the stack and apply operations, push the result into the stack
            if ("+".equals(s)) {
                int result = stack.pop() + stack.pop();
                stack.push(result);
            } else if ("-".equals(s)) {
                // First number popped is the second operand
                int m = stack.pop();
                // Second number popped is the first operand
                int n = stack.pop();
                int result = n - m;
                stack.push(result);
            } else if ("*".equals(s)) {
                int result = stack.pop() * stack.pop();
                stack.push(result);
            } else if ("/".equals(s)) {
                // First number popped is divisor
                int m = stack.pop();
                // Second number popped is the dividend
                int n = stack.pop();
                int result = n / m;
                stack.push(result);
            }
            // If the token is a number, push it into the stack
            else stack.push(Integer.valueOf(s));
        }
        // return the final result
        return stack.pop();
    }

    public static void main(String args[]) {
        EvalRPN evalRPN = new EvalRPN();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] tokens = input.split(" ");
        System.out.println(evalRPN.evalRPN(tokens));
        sc.close();
    }
}

// time operation: O(n)
// space operation: O(n)