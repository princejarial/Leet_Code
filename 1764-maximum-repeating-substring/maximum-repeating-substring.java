class Solution {
    public int maxRepeating(String sequence, String word) {
        int maxPossibleRepetitions = sequence.length() / word.length();
      
        for (int k = maxPossibleRepetitions; k > 0; k--) {
            String repeatedWord = word.repeat(k);
          
            if (sequence.contains(repeatedWord)) {
                return k;
            }
        }
      
        return 0;
    }
}