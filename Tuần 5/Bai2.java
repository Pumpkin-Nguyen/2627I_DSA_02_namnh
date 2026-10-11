
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

class Bai2 {

    public static int introTutorial(int V, List<Integer> arr) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.size());
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int V = Integer.parseInt(sc.nextLine());
            int n = Integer.parseInt(sc.nextLine());

            List<Integer> arr = Stream.of(sc.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

            System.out.println(introTutorial(V, arr));
        }
    }


}

class MergeSort {
    void merge(List<Integer> arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] M = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr.get(p + i);
        }

        for (int j = 0; j < n2; j++) {
            M[j] = arr.get(q + 1 + j);
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, M[j]);
                j++;
            }
            k++;
        }
    }

    public void mergeSort(List<Integer> arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public void printArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}
