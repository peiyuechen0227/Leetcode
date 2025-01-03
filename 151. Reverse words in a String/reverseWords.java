import java.util.Scanner;

public class reverseWords {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        StringBuilder result = new StringBuilder();

        int r = n - 1;

        while (r >= 0) {
            while (r >= 0 && arr[r] == ' ') {
                r--;
            }
            int l = r;
            while (l >= 0 && arr[l] != ' ') {
                l--;
            }
            if (r > l) {
                result.append(s.substring(l + 1, r + 1));
                result.append(' ');
            }
            r = l - 1;
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        reverseWords rw = new reverseWords();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(rw.reverseWords(s));
    }
}
