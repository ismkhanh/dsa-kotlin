class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy {it.second})
        for (entry in map) {
            val (key, value) = entry
            pq.add(Pair(key, value))
            if(pq.size > k) {
                pq.poll()
            }
        }
        val ans = IntArray(k) {0}
        var index = 0
        while (pq.isNotEmpty()) {
            ans[index] = pq.poll().first
            index++
        }
        return ans
    }
}
