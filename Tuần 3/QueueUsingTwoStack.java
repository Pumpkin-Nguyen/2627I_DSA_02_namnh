
import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingTwoStack {
    static class MyQueue {
        private Deque<Integer> stIn = new ArrayDeque<>();
        private Deque<Integer> stOut = new ArrayDeque<>();

        public void enqueue(int x) {
            stIn.push(x);
        }

        private void shiftStacks() {
            if (stOut.isEmpty()) {
                while (!stIn.isEmpty()) {
                    stOut.push(stIn.pop());
                }
            }
        }

        public void dequeue() {
            shiftStacks();
            if (!stOut.isEmpty()) {
                stOut.pop();
            }
        }

        public int peek() {
            shiftStacks();
            return stOut.peek();
        }
    }

public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Chuỗi truy vấn mẫu:
        // 1 42  -> thêm 42
        // 2     -> xóa đầu
        // 1 14  -> thêm 14
        // 3     -> in đầu (kỳ vọng: 14)
        // 1 28  -> thêm 28
        // 3     -> in đầu (kỳ vọng: 14)
        // 1 60  -> thêm 60
        // 1 78  -> thêm 78
        // 2     -> xóa đầu (14)
        // 2     -> xóa đầu (28)
        
        queue.enqueue(42); // 1 42
        queue.dequeue();    // 2
        queue.enqueue(14); // 1 14
        
        System.out.println("Query 3 (Front): " + queue.peek()); // In ra: 14
        
        queue.enqueue(28); // 1 28
        System.out.println("Query 3 (Front): " + queue.peek()); // In ra: 14
        
        queue.enqueue(60); // 1 60
        queue.enqueue(78); // 1 78
        
        queue.dequeue();    // 2 (bỏ 14)
        queue.dequeue();    // 2 (bỏ 28)
        
        System.out.println("Query 3 (Front): " + queue.peek()); // In ra: 60
    }
}
