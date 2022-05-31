//You are given a nested list of integers nestedList. Each element is either an 
//integer or a list whose elements may also be integers or other lists. Implement 
//an iterator to flatten it. 
//
// Implement the NestedIterator class: 
//
// 
// NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with 
//the nested list nestedList. 
// int next() Returns the next integer in the nested list. 
// boolean hasNext() Returns true if there are still some integers in the 
//nested list and false otherwise. 
// 
//
// Your code will be tested with the following pseudocode: 
//
// 
//initialize iterator with nestedList
//res = []
//while iterator.hasNext()
//    append iterator.next() to the end of res
//return res
// 
//
// If res matches the expected flattened list, then your code will be judged as 
//correct. 
//
// 
// Example 1: 
//
// 
//Input: nestedList = [[1,1],2,[1,1]]
//Output: [1,1,2,1,1]
//Explanation: By calling next repeatedly until hasNext returns false, the 
//order of elements returned by next should be: [1,1,2,1,1].
// 
//
// Example 2: 
//
// 
//Input: nestedList = [1,[4,[6]]]
//Output: [1,4,6]
//Explanation: By calling next repeatedly until hasNext returns false, the 
//order of elements returned by next should be: [1,4,6].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nestedList.length <= 500 
// The values of the integers in the nested list is in the range [-10⁶, 10⁶]. 
// 
// Related Topics Stack Tree Depth-First Search Design Queue Iterator 👍 3721 👎
// 1307


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger e = stack.pop();
            List<NestedInteger> children = e.getList();
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }

        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
