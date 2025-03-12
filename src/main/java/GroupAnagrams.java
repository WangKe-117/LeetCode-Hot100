import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[] strs = new String[size];
        scanner.nextLine();
        for (int i = 0; i < size; i++) {
            strs[i] = scanner.nextLine();
        }
        List<List<String>> result = solution(strs);
        System.out.println(result);
    }

    public static List<List<String>> solution(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            }
            else {
                ArrayList<String> array = new ArrayList<>();
                array.add(str);
                map.put(sortedStr, array);
            }
        }
        return new ArrayList<>(map.values());
    }
}
