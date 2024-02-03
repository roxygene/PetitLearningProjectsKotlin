import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SelectionSortTest {
    private lateinit var selectionSort: SelectionSort
    private lateinit var testArray: Array<Int>
    private lateinit var testArray1: Array<Int>

    @BeforeEach
    fun setUp() {
        selectionSort = SelectionSort()
        testArray = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        testArray1 = arrayOf( 5, 6, 7, 2, 3, 4, 0, 1, 8, 9)

    }

    @Test
    fun swapElements() {
        selectionSort.swapElements(2, 5, testArray)
        assertEquals(testArray[2], 5)
        assertEquals(testArray[5], 2)

    }

    @Test
    fun findLowestElementsIndex() {
        assertEquals(selectionSort.findLowestElementsIndex(0, testArray), 0)
        assertEquals(selectionSort.findLowestElementsIndex(3, testArray), 3)
        assertEquals(selectionSort.findLowestElementsIndex(2, testArray1), 6)
        assertEquals(selectionSort.findLowestElementsIndex(7, testArray1),7)
    }

    @Test
    fun sort() {
        assertArrayEquals(selectionSort.sort(testArray1), testArray)
    }
}