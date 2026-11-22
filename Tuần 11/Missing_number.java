import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (Integer num : brr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Integer num : arr) {
            count.put(num, count.get(num) - 1);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 0) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }

    public static List<Integer> missingNumbers_2(List<Integer> arr, List<Integer> brr) {
        Collections.sort(arr);
        Collections.sort(brr);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = arr.size(), m = brr.size();

        while (j < m) {
            if (i < n && arr.get(i).equals(brr.get(j))) {
                i++;
                j++;
            } else {
                int missing = brr.get(j);
                if (result.isEmpty() || result.get(result.size() - 1) != missing) {
                    result.add(missing);
                }
                j++;
            }
        }

        return result;

    }    
    
    public static List<Integer> missingNumbers_3(List<Integer> arr, List<Integer> brr) {
        int minVal = Integer.MAX_VALUE;
        for (int x : brr) {
            if (x < minVal) { minVal = x ;}
        }

        int[] count = new int[101];

        for (int x : brr) {
            count[x - minVal]++;
        }

        for (int x : arr) {
            count[x - minVal]--;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            if (count[i] > 0) {
                result.add(i + minVal);
            }
        }

        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
