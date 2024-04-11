import java.util.Scanner;

public class prefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //nhập độ dài mảng và số lượng truy vấn
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        //nhập mảng
        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextLong();
        }
        // tính prefix sum
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        // In mảng prefix sum
        for (int i = 1; i <= n; i++) {
            System.out.print(prefixSum[i] + " ");
        }
        System.out.println();

        // trong q truy vấn, nhập khoảng (l,r) cần tính prefix
        for (int i = 0; i < q; i++) {
            // Đọc cặp giá trị l, r
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            long result = prefixSum[r] - prefixSum[l - 1];
            System.out.println(result);
        }
        scanner.close();
    }
}
