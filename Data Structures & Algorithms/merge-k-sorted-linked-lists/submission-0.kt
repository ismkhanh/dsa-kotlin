/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val dummyNode = ListNode(-1)
        var curNode = dummyNode
        var hasNode = true
        val map = mutableMapOf<Int, ListNode?>()
        for(i in 0 until lists.size) map[i] = lists[i]

        do {
            hasNode = false
            var min = Int.MAX_VALUE
            var minKey = -1
            for(key in map.keys) {
                if (map[key] != null) {
                    hasNode = true
                    val curMin = map[key]!!.`val`
                    if (curMin < min) {
                        min = curMin
                        minKey = key
                    }
                }
            }
            if (hasNode) {
                curNode.next = ListNode(min)
                curNode = curNode.next!!
                map[minKey] = map[minKey]?.next
            }
           
        } while (hasNode)
        

        return dummyNode.next
    }
}
