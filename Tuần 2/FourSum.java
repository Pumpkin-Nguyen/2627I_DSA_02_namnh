import java.util.ArrayList;
import java.util.Arrays;

class FourSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i && arr[j] == arr[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        ArrayList<Integer> temp_res = new ArrayList<>();
                        temp_res.add(arr[i]);
                        temp_res.add(arr[j]);
                        temp_res.add(arr[left]);
                        temp_res.add(arr[right]);

                        res.add(temp_res);

                        left++;
                        right--;

                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        int target = 23;

        ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);

        for (ArrayList<Integer> v : ans) {
            for (int x : v) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
