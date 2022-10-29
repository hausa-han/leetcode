class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] charNums = new int[26];

        for (int i=0; i<magazine.length(); i++){
            charNums[magazine.charAt(i)-'a']++;
        }

        for (int i=0; i<ransomNote.length(); i++){
            if (charNums[ransomNote.charAt(i) - 'a'] == 0){
                return false;
            } else {
                charNums[ransomNote.charAt(i) - 'a'] --;
            }
        }
        return true;
    }
}