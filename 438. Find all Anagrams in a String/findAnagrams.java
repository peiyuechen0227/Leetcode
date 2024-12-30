class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] record = new int[26];
        int[] sRecord = new int[26];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            record[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sRecord[s.charAt(i) - 'a']++;
            if (i >= p.length() - 1) {
                if (isAnagram(record, sRecord)) {
                    list.add(i - p.length() + 1);
                }
                sRecord[s.charAt(i - p.length() + 1) - 'a']--;
            }
        }
        return list;
    }

    public boolean isAnagram(int[] array1, int[] array2) {
        for (int i = 0; i < 26; i++) {
            if (array1[i] - array2[i] != 0) {
                return false;
            }
        }
        return true;
    }
}