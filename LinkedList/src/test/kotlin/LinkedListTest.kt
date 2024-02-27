import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.lang.IndexOutOfBoundsException

class LinkedListTest {
    private lateinit var list1: LinkedList<Int>
    private lateinit var list2: LinkedList<String>

    @BeforeEach
    fun setUp() {
        list1 = LinkedList()
        list2 = LinkedList()
        list2.add("a")
        list2.add("b")
        list2.add("c")
    }

    @Test
    fun get() {
        list1.add(1)
        assertEquals(1, list1.get(0))
        assertNotEquals(0, list1.get(0))
    }

    @Test
    fun getNode() {
        list1.add(1)
        assertEquals(1, list1.getNode(0)?.data)
        assertNotEquals(0, list1.getNode(0)?.data)
        assertThrows(IndexOutOfBoundsException::class.java) {
            list1.getNode(-1)?.data
        }
        assertThrows(IndexOutOfBoundsException::class.java) {
            list1.getNode(2)?.data
        }
    }

    @Test
    fun add() {
        list1.add(3)
        list1.add(2)
        list1.add(1)
        assertEquals(list1.head?.data, 3)
        assertEquals(list1.getNode(1)?.data, 2)
        assertEquals(list1.toString(), "3, 2, 1")
        assertNotEquals(list1.head?.data, 2)
        assertNotEquals(list1.head?.data, 1)
    }

    @Test
    fun addWithIndex() {
        assertEquals(list2.getNode(0)?.data, "a")
        assertEquals(list2.getNode(1)?.data, "b")
        list2.add("x", 1)
        assertEquals(list2.getNode(1)?.data, "x")
        assertEquals(list2.getNode(2)?.data, "b")
        assertEquals(list2.getNode(4)?.data, null)
        assertEquals(list2.toString(), "a, x, b, c")
        list2.add("z", 0)
        assertEquals(list2.getNode(0)?.data, "z")
        assertEquals(list2.getNode(1)?.data, "a")
    }

    @Test
    fun remove() {
        assertEquals(list2.toString(), "a, b, c")
        list2.remove(1)
        assertEquals(list2.getNode(0)?.data, "a")
        assertEquals(list2.getNode(1)?.data, "c")
    }

    @Test
    fun removeFirst() {
        assertEquals(list2.toString(), "a, b, c")
        list2.remove(0)
        assertEquals(list2.getNode(0)?.data, "b")
        assertEquals(list2.getNode(1)?.data, "c")
        assertEquals(list2.getNode(2)?.data, null)
    }

    @Test
    fun removeLast() {
        assertEquals(list2.toString(), "a, b, c")
        list2.remove(2)
        assertEquals(list2.getNode(0)?.data, "a")
        assertEquals(list2.getNode(1)?.data, "b")
        assertEquals(list2.getNode(2)?.data, null)
    }


}