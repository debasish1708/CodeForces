package BitMasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PetrAndCombination_1097B {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        float nextFloat() throws IOException {
            return Float.parseFloat(next());
        }

        short nextShort() throws IOException {
            return Short.parseShort(next());
        }

        byte nextByte() throws IOException {
            return Byte.parseByte(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        char nextChar() throws IOException {
            return next().charAt(0);
        }

        int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        String[] nextStringArray(int n) throws IOException {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = next();
            }
            return arr;
        }

        char[] nextCharArray() throws IOException {
            return next().toCharArray();
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = sc.nextIntArray(n);
        
        for(int mask=0;mask<(1<<n);mask++){
            int sum=0;
            for(int i=0;i<n;i++){
                int bitMask = (mask & (1<<i));
                if(bitMask == 0){
                    sum += arr[i];
                } else {
                    sum -= arr[i];
                }
            }

            if(sum%360==0){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
}
