// Definition for a pair
// class Pair(var key: Int, var value: String)

class Solution {
    fun insertionSort(pairs: MutableList<Pair>): List<List<Pair>> {
        val res = mutableListOf<List<Pair>>()

        for(i in 0 until pairs.size) {
            var j = i
            while(j > 0 && isLower(pairs[j], pairs[j-1])) {
                swap(j, j-1, pairs)
                j--
            }
            res.add(pairs.toList())
        }

        return res
    }

    private fun swap(i: Int, j: Int, pairs: MutableList<Pair>) {
        val tmp = pairs[j]
        pairs[j] = pairs[i]
        pairs[i] = tmp 
    }

    private fun isLower(pair1: Pair, pair2: Pair): Boolean {
        return pair1.key < pair2.key
    }
}
