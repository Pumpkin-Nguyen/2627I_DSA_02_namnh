
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] result = findMaxMin(nums, 0, nums.length - 1);

        System.out.println("Max: " + result[1]);
        System.out.println("Min: " + result[0]);
    }

    public static int[] findMaxMin(int[] arr, int low, int high) {
        // result = [min, max]
        int[] result = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

        // case 1: only 1 number
        if (low == high) {
            result[0] = arr[low];
            result[1] = arr[low];
            return result;
        }

        // case 2: 2 numbers
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result[0] = arr[low];
                result[1] = arr[high];
            } else {
                result[0] = arr[high];
                result[1] = arr[low];
            }
            return result;
        }

        int mid = (low + high) / 2;
        int[] result_left = findMaxMin(arr, low, mid);
        int[] result_right = findMaxMin(arr, mid + 1, high);

        result[0] = (result_left[0] < result_right[0]) ? result_left[0] : result_right[0];
        result[1] = (result_left[1] > result_right[1]) ? result_left[1] : result_right[1];

        return result;
    }
}
