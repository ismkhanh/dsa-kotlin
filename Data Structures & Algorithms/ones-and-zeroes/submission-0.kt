class Solution {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val maxCapacity = Capacity(m, n)
        val capacities: List<Capacity> = strs.map { getCapacity(it) }
        val cache = mutableMapOf<Pair<Int, Capacity>, Int>()
        return count(0, capacities, maxCapacity, cache)
    }

    fun count(
        i: Int, 
        capacities: List<Capacity>, 
        capacity: Capacity,
        cache: MutableMap<Pair<Int, Capacity>, Int>
    ): Int {
        if (i == capacities.size) return 0
        cache[i to capacity]?.let{ return it}

        var maxCount = count(i+1, capacities, capacity, cache)
        val newCapacity = capacity.subtract(capacities[i])
        if (newCapacity.isValid()) {
            val curCount = 1 + count(i+1, capacities, newCapacity, cache)
            maxCount = maxOf(maxCount, curCount)
        }
        cache[i to capacity] = maxCount
        return maxCount
    }

    fun getCapacity(str: String): Capacity {
        var m = 0
        var n = 0
        for(c in str) {
            if (c == '0') m++
            else if (c == '1') n++
        }
        return Capacity(m, n)
    }
}

data class Capacity(val m: Int, val n: Int) {
    fun isValid() = m >= 0 && n >= 0
    fun subtract(newCapacity: Capacity): Capacity {
        return Capacity(m - newCapacity.m, n-newCapacity.n)
    }
}