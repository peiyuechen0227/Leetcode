import java.util.Scanner;

public class reverseStr {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i += 2 * k) {
            int l = i;
            int r = Math.min(i + k - 1,n - 1);
            reverse(l, r, arr);
        }

        String str = new String(arr);
        return str;
    }

    public void reverse(int l, int r, char[] arr) {
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        reverseStr rs = new reverseStr();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        String str = rs.reverseStr(s, k);
        System.out.println(str);
    }
}
