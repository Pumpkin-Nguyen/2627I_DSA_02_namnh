import java.io.*;
import java.util.*;

public class W7_25020281 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int N = scanner.nextInt();

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(N / 2 + 1, Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(N / 2 + 1);

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();

            if (maxPQ.isEmpty() || num <= maxPQ.peek()) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }

            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.offer(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }

            if (maxPQ.size() > minPQ.size()) {
                System.out.printf("%.1f\n", (double) maxPQ.peek());
            } else {
                double median = (maxPQ.peek() + minPQ.peek()) / 2.0;
                System.out.printf("%.1f\n", median);
            }
        }
        scanner.close();
    }
}
