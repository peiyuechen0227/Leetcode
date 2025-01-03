import java.util.Scanner;

public class reverseString {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }

//        while (l < r) {
//            char temp = s[l];
//            s[l] = s[r];
//            s[r] = s[l];
//            l++;
//            r--;
//        }
    }
    public static void main(String[] args) {
        reverseString rs = new reverseString();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        rs.reverseString(arr);
        System.out.println(arr);
    }
}
