//The median is the middle value in an ordered integer list. If the size of the 
//list is even, there is no middle value and the median is the mean of the two 
//middle values. 
//
// 
// For example, for arr = [2,3,4], the median is 3. 
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5. 
// 
//
// Implement the MedianFinder class: 
//
// 
// MedianFinder() initializes the MedianFinder object. 
// void addNum(int num) adds the integer num from the data stream to the data 
//structure. 
// double findMedian() returns the median of all elements so far. Answers 
//within 10⁻⁵ of the actual answer will be accepted. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//Output
//[null, null, null, 1.5, null, 2.0]
//
//Explanation
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
// 
//
// 
// Constraints: 
//
// 
// -10⁵ <= num <= 10⁵ 
// There will be at least one element in the data structure before calling 
//findMedian. 
// At most 5 * 10⁴ calls will be made to addNum and findMedian. 
// 
//
// 
// Follow up: 
//
// 
// If all integer numbers from the stream are in the range [0, 100], how would 
//you optimize your solution? 
// If 99% of all integer numbers from the stream are in the range [0, 100], how 
//would you optimize your solution? 
// 
// Related Topics Two Pointers Design Sorting Heap (Priority Queue) Data Stream 
//👍 6094 👎 113


import java.util.Collections;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    int size = 0;
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()), right = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (left.isEmpty()) {
            if (right.isEmpty() || num >= right.peek()) right.offer(num);
            else left.offer(num);
        } else {
            if (num <= left.peek()) left.offer(num);
            else right.offer(num);
        }

        size++;
        while (left.size() > size / 2) right.offer(left.poll());
        while (left.size() < size / 2) left.offer(right.poll());
    }

    public double findMedian() {
        if (size % 2 == 0) return left.peek() / 2.0 + right.peek() / 2.0;
        else return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
