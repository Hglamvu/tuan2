public class prefixsum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 3, 1, 4, 2};

        //hàm tính và in ra mảng chứa dãy các prefix sum
        printPrefixSum(arr);
    }

    //tính và in ra mảng chứa dãy các prefix sum
    private static void printPrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1]; 
        //lưu trữ kết quả từ index 1 đến n

        // Tính toán prefix sum bắt đầu từ index 1
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        // In ra mảng chứa dãy các prefix sum
        for (int i = 1; i <= n; i++) {
            System.out.print(prefixSum[i] + " ");
        }
    }
}
