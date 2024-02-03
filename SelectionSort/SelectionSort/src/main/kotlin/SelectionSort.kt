class SelectionSort {

    fun swapElements(i: Int, j: Int, array: Array<Int>): Unit {
        var tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
    }

    fun findLowestElementsIndex(startIndex: Int, array: Array<Int>): Int {
        var lowestElementIndex = startIndex
        for(index in startIndex .. array.size - 1) {
            if(array[index] < array[lowestElementIndex]) {
                lowestElementIndex = index
            }
        }
        return lowestElementIndex
    }

    fun sort(array: Array<Int>): Array<Int> {
        for(index in array.indices) {
            var lowestIndex = findLowestElementsIndex(index, array)
            swapElements(index, lowestIndex, array)
        }
        return array
    }
}