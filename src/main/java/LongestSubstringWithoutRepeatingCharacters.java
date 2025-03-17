import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String result = solution(s);
        System.out.println(result);
    }

    public static String solution(String s) {
        int max_length = 0;
        int left = 0, right = 0;
        int saveLeft = 0, saveRight = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add((s.charAt(right)));
                right++;
            }
            if (set.size() > max_length) {
                saveLeft = left;
                saveRight = right;
                max_length = set.size();
            }

        }
        return s.substring(saveLeft, saveRight); //返回要找的字串
//        return max_length;
    }
}
