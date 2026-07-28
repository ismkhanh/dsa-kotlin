/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        if (intervals.isEmpty()) return 0
        //sort in asc order based on the start time
        val sorted = intervals.sortedBy{ it.start }

        //stores interval sorted by the end times in asc order
        val minPQ = PriorityQueue<Interval>(compareBy{ it.end })
        
        var maxRooms = 0
        for(curInterval in sorted) {
            while(minPQ.isNotEmpty() && minPQ.peek().end <= curInterval.start) {
                // remove any interval which can be removed i.e whose end time <= cur.start
                minPQ.poll()
            }
            minPQ.add(curInterval)
            maxRooms = maxOf(maxRooms, minPQ.size)
        }

        return maxRooms
    }
}