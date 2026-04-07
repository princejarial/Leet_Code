import java.util.*;

class Fancy {

    List<Long> list;
    long mul, add;
    int MOD = 1_000_000_007;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }
    
    public void append(int val) {
        // reverse the transformation
        long inv = modInverse(mul);
        long stored = ((val - add + MOD) % MOD * inv) % MOD;
        list.add(stored);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;

        long val = list.get(idx);
        return (int)((val * mul + add) % MOD);
    }

    // Fermat’s Little Theorem
    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long x, long y) {
        long res = 1;
        x %= MOD;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }
}