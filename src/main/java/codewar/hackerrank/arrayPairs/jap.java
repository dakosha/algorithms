package codewar.hackerrank.arrayPairs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public final class jap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static FastScanner sc = new FastScanner(br);
    static PrintWriter out = new PrintWriter(System.out);
    static int[] log;
    static int[][] st;
    static long[] a;
    static int n;
    static int maxn = (int) (5e5) + 5;

    static int getMax(int l, int r) {
        int size = log[r - l], val1 = st[size][l], val2 = st[size][r - (1 << size) + 1];
        return (a[val1] > a[val2] ? val1 : val2);
    }

    static void buildST() {
        log = new int[maxn];
        for (int i = 2; i < maxn; i++) {
            log[i] = log[i >> 1] + 1;
        }
        st = new int[log[maxn - 1]][n + 1];
        for (int i = 1; i <= n; i++) {
            st[0][i] = i;
        }
        for (int mask = 1; (1 << mask) <= n + 1; mask++) {
            for (int i = 1; i + (1 << mask) - 1 <= n; i++) {
                int x = st[mask - 1][i], y = st[mask - 1][i + (1 << (mask - 1))];
                st[mask][i] = (a[x] > a[y] ? x : y);
            }
        }
    }

    static long solve(int s, int e) {
        if (s >= e) {
            return 0;
        } else {
            int max = getMax(s, e);
            List<Long> list = new ArrayList<Long>();
            for (int i = max; i <= e; i++) {
                list.add(a[i]);
            }
            long res = 0;
            for (int i = max + 1; i <= e; i++) {
                if (a[i] == 1) {
                    res++;
                }
            }
            Collections.sort(list);
            for (int i = s; i < max; i++) {
                int low = 0, high = list.size() - 1;
                while (low < high) {
                    int mid = (low + high + 1) >> 1;
                    long curr = list.get(mid);
                    if (curr * a[i] <= a[max]) {
                        low = mid;
                    } else {
                        high = mid - 1;
                    }
                }
                if (a[i] * list.get(low) <= a[max]) {
                    res = res + (low + 1);
                }
            }
            //out.println(s+" "+e+" "+res);
            return (res + solve(s, max - 1) + solve(max + 1, e));
        }
    }


    public static void run() throws Exception {
        n = sc.nextInt();
        a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
        }
        buildST();
        out.println(solve(1, n));
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new jap().run();
                } catch (Exception e) {

                }
            }
        }, "1", 1 << 28).start();
    }
}

class FastScanner {
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public String next() throws Exception {
        return nextToken().toString();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}