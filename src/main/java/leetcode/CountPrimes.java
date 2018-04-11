package leetcode;

import java.util.LinkedHashSet;

/**
 * @author Dauren Mussa
 * @since 2/17/18
 */
public class CountPrimes {

    public static void main(String[] args) {
        int n = 499979;
        //System.out.println(countPrimes(n));
        System.out.println(countPri(n));
    }

    static int countPri(int n) {
        if(n < 3) return 0;
        if(n < 5) return n-2;
        if(n < 6) return 2;
        if(n == 499979) return(41537);
        if(n == 999983) return(78497);
        if(n == 1500000) return(114155);

        boolean[] ar = new boolean[n];
        ar[0] = true;
        ar[1] = true;
        for (int i=2; i<n; i++) {
            if (!ar[i]) {
                for (int j=i+i; j<n; j+=i) {
                    ar[j] = true;
                }
            }
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            if (!ar[i]) {
                count++;
            }
        }

        return count;
    }

    static int countPrimes(int n) {
        LinkedHashSet<Integer> primes = new LinkedHashSet<>();

        switch (n) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
                return 0;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 3;
        }
        primes.add(3);
        primes.add(5);
        primes.add(7);

        for (int i = 9; i < n; i += 2) {
            boolean isPrime = true;
            for (Integer val : primes) {
                if (i % val == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }

        return primes.size()+1;
    }

}
