public class countingsort {

    public static void countingSort(int[] a) {
        // tìm giá trị max cua mảng
        int max = Integer.MIN_VALUE;
        for (int num : a) {
            max = Math.max(max, num);
        }

        //đếm tần suất xuất hiện các giá trị của mảng
        int[] c = new int[max + 1];
        for (int num : a) {
            c[num]++;
        }
        // c[i] chứa lượng phần tử nhỏ hơn hoặc bằng i
        for (int i = 1; i <= max; i++) {
            c[i] += c[i - 1];
        }

        // Xây dựng mảng kết quả
        int[] result = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            result[--c[a[i]]] = a[i];
        }
        // Sao chép mảng kết quả vào mảng ban đầu
        for (int i = 0; i < a.length; i++) {
            a[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1, 3, 2};
        countingSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
