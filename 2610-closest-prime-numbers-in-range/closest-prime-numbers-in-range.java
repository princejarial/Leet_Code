class Solution {
    public int[] closestPrimes(int left, int right) {

        boolean[] isPrime = new boolean[right + 1];
        
        for (int i = 2; i <= right; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int prev = -1;
        int num1 = -1, num2 = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (i >= 2 && isPrime[i]) {
                if (prev != -1) {
                    int diff = i - prev;
                    if (diff < minDiff) {
                        minDiff = diff;
                        num1 = prev;
                        num2 = i;
                    }
                }
                prev = i;
            }
        }

        return new int[]{num1, num2};
    }
}