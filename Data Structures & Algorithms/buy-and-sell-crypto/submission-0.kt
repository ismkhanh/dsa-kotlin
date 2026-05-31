class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minSeen = prices[0]
        var ans = 0
        for (i in 1 until prices.size) {
            val profit = prices[i] - minSeen
            minSeen = minOf(minSeen, prices[i])
            ans = maxOf(profit, ans)
        }
        return ans 
    }
}
