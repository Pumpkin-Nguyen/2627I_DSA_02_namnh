
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

class Bai1 {

    public static int introTutorial(int V, List<Integer> arr) {
        int l = 0;
        int r = arr.size() - 1;
        
        while (l <= r) {
            int m = (l + r) / 2;

            int val = arr.get(m);
            if (val == V) {
                return m;
            } else if (val < V) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
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
