import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        List<Integer> result = solution(s, p);
        System.out.println(result);
    }

    public static List<Integer> solution(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] wa = new int[26];
        int[] pa = new int[26];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int left = 0, right = 0;
        for (char c : pc) {
            pa[c-'a']++;
        }
        while (right < sc.length) {
            wa[sc[right]-'a']++;
            if (right - left + 1 > pc.length) {
                wa[sc[left]-'a']--;
                left++;
            }
            if (right - left + 1 == pc.length) {
                if (Arrays.equals(wa, pa)){
                    res.add(left);
                }
            }
            right++;
        }
        return res;
    }
}
