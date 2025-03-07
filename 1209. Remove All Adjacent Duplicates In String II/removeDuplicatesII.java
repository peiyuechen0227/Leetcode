// class Solution {
//     class Pair {
//         char ch;
//         int count;

//         Pair(char ch, int count) {
//             this.ch = ch;
//             this.count = count;
//         }
//     }

//     public String removeDuplicates(String s, int k) {
//         Stack<Pair> stack = new Stack<>();

//         for (char c: s.toCharArray()) {
//             // Push c and its frequency into stack
//             if (!stack.isEmpty() && stack.peek().ch == c) {
//                 stack.peek().count++;
//             } else {
//                 stack.push(new Pair(c, 1));
//             }

//             // Pop when count is k
//             if (stack.peek().count == k) {
//                 stack.pop();
//             }
//         }

//         StringBuilder result = new StringBuilder();
//         for (Pair p : stack) {
//             result.append(String.valueOf(p.ch).repeat(p.count));
//         }

//         return result.toString();
//     }
// }

class Solution {
    public String removeDuplicates(String s, int k) {
        char[] stack = s.toCharArray();
        int[] count = new int[s.length()];
        int slow = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            stack[slow] = stack[fast];

            if (slow > 0 && stack[slow] == stack[slow - 1]) {
                count[slow] = count[slow - 1] + 1;
            } else {
                count[slow] = 1;
            }

            if (count[slow] == k) {
                slow -= k;
            }

            slow++;
        }
        return new String(stack, 0, slow);
    }
}
