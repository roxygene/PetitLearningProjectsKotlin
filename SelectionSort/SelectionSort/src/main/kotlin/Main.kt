fun main(args: Array<String>) {
    val array = arrayOf(5, 8, 4, 9, 0, 11, -2)
    val selectionSort = SelectionSort()

    println("Array: ${array.contentToString()}")
    println("Sorted array: ${selectionSort.sort(array).contentToString()}")
}