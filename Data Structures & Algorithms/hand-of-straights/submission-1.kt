class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false
        val map = mutableMapOf<Int, Int>()
        val minPQ = PriorityQueue<Int>()
        for(ele in hand) {
            if(map.containsKey(ele)) {
                map[ele] = map[ele]!! + 1
            } else {
                map[ele] = 1
                minPQ.add(ele)
            }
        }

        while(minPQ.isNotEmpty()) {
            var cur = minPQ.peek()
            var curSize = 0
            while(map.containsKey(cur) && map[cur]!! > 0) {
                map[cur] = map[cur]!!-1
                if (map[cur]!! == 0) minPQ.remove(cur)

                curSize++
                cur++
                
                if (curSize == groupSize) break
            }
            if (curSize != groupSize) return false
        }

        return minPQ.isEmpty()
    }
}
