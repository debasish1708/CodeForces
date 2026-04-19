import java.io.*;
import java.util.*;

public class BNetWorkTopology_292B {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] degree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            degree[u]++;
            degree[v]++;
        }

        int count1 = 0, count2 = 0, countNminus1 = 0;

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 1) count1++;
            else if (degree[i] == 2) count2++;
            else if (degree[i] == n - 1) countNminus1++;
        }

        if (countNminus1 == 1 && count1 == n - 1) {
            System.out.println("star topology");
        } else if (count1 == 2 && count2 == n - 2) {
            System.out.println("bus topology");
        } else if (count2 == n) {
            System.out.println("ring topology");
        } else {
            System.out.println("unknown topology");
        }
    }
}