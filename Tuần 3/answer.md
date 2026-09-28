# 1. COS226, Midterm f24, 6
- Self-printing queue là loại hàng đợi chứa các số nguyên, được cài đặt bằng một danh sách liên kết và cứ sau ba thao tác (enqueue hoặc dequeue) lại tự in nội dung của queue ra input chuẩn. Ví dụ chuỗi enqueue(0), dequeue(), enqueue(0) sẽ in ra 0.
 
- (a) Bắt đầu từ một queue rỗng, chuỗi sau sẽ in ra nội dung gì??
enqueue(0), enqueue(1), dequeue(), enqueue(2), enqueue(3), dequeue(), enqueue(4), enqueue(5), dequeue(), enqueue(6), enqueue(7), dequeue()

=> 0 1 2 3

- (b) Thao tác enqueue của self-printing queue chứa n phần tử có thời gian chạy trong trường hợp tồi nhất là loại nào?

=> Vì có cả thao tác in lại queue, nên thời gian chạy trong trường hợp tồi nhất là O(n)

- (c) Thời gian chạy trung bình (amortized) trên mỗi thao tác đối với n thao tác `enqueue()` và `dequeue()` trên một hàng đợi loại self-printing queue ban đầu rỗng là bao nhiêu? Biết rằng đại lượng này được định nghĩa là tổng thời gian chạy trong trường hợp xấu nhất của bất kỳ chuỗi hỗn hợp nào gồm n thao tác `enqueue()` và `dequeue()` bắt đầu từ một hàng đợi tự in rỗng, chia cho n.

=> O(1)