import java.util.*;
public class isPalindrome {
    private boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < charArray.length; fast++) {
            if (charArray[fast] >= 'a' && charArray[fast] <= 'z' || charArray[fast] >= '0' && charArray[fast] <= '9') {
                charArray[slow] = charArray[fast];
                slow++;

            } else if (charArray[fast] >= 'A' && charArray[fast] <= 'Z') {
                charArray[slow] = (char) (charArray[fast] + 32);
                slow++;
            }
        }

        int left = 0;
        int right = slow - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new String("A man, a plan, a canal: Panama");
        isPalindrome isPalindrome = new isPalindrome();
        System.out.println(isPalindrome.isPalindrome(s));
    }
}