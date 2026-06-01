class Solution {
    fun maxProfit(prices: IntArray): Int {
       var minSeen = prices[0]
       var maxProfit = 0
       for (i in 1 until prices.size) {
        maxProfit = maxOf(maxProfit, prices[i] - minSeen)
        minSeen = minOf(minSeen, prices[i])
       }
       return maxProfit
    }
}
