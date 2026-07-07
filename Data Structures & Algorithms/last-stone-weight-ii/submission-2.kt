class Solution {
    fun lastStoneWeightII(stones: IntArray): Int {
        if (stones.size == 1) return stones[0]
        if (stones.size == 2) return Math.abs(stones[0] - stones[1])
        val cache = mutableMapOf<Pair<Int, Int>, Int>()
        return smallest(0, 0, stones, cache)
    }

    fun smallest(index: Int, curCount: Int, stones: IntArray, cache: MutableMap<Pair<Int,Int>, Int>): Int {
        if (index >= stones.size) return Math.abs(curCount)
        cache[index to curCount]?.let{return it}
        val add = smallest(index+1, curCount + stones[index], stones, cache)
        val subtract = smallest(index+1, curCount - stones[index], stones, cache)
        val minCount = minOf(add, subtract)
        cache[index to curCount] = minCount
        return minCount
    }

}
