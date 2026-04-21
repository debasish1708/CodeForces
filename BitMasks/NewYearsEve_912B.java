package BitMasks;
import java.io.*;
import java.util.*;

public class NewYearsEve_912B {
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
        long answer = 0;
        long n = sc.nextLong();
        long k = sc.nextLong();
        if(k==1){
            System.out.println(n);
            return;
        }
 
        long temp = n;
        int i=0;
        while(temp>0){
            if((temp & 1) == 0){
                answer |= (1L<<i);
            }
            temp >>= 1;
            i++;
        }
        long ans = n^answer;
        System.out.println(ans);
    }
}