//Given two numbers, hour and minutes, return the smaller angle (in degrees) 
//formed between the hour and the minute hand. 
//
// Answers within 10⁻⁵ of the actual value will be accepted as correct. 
//
// 
// Example 1: 
//
// 
//Input: hour = 12, minutes = 30
//Output: 165
// 
//
// Example 2: 
//
// 
//Input: hour = 3, minutes = 30
//Output: 75
// 
//
// Example 3: 
//
// 
//Input: hour = 3, minutes = 15
//Output: 7.5
// 
//
// 
// Constraints: 
//
// 
// 1 <= hour <= 12 
// 0 <= minutes <= 59 
// 
// Related Topics Math 👍 817 👎 171


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double angleClock(int hour, int minutes) {
        double p = (minutes + 0.0) / 60.0;
        double a1 = hour * 30 + 30 * p;
        double a2 = minutes * 6.0;

        double res = Math.abs(a2 - a1);
        if(res > 180.0){
            res = 360.0 - res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
