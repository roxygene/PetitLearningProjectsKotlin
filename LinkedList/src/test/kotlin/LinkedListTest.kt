import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.lang.IndexOutOfBoundsException

class LinkedListTest {
    private lateinit var list1: LinkedList<Int>
    private lateinit var list2: LinkedList<String>
    private lateinit var list3: LinkedList<Int>

    @BeforeEach
    fun setUp() {
        list1 = LinkedList()

        list2 = LinkedList()
        list2.add("a")
        list2.add("b")
        list2.add("c")

        list3 = LinkedList()
        list3.add(10)
        list3.add(11)
        list3.add(12)
        list3.add(13)

    }

    @Test
    fun countTheSizeOfList() {
        assertEquals(0, list1.countTheSizeOfList(list1.head))
        assertEquals(3, list2.countTheSizeOfList(list2.head))
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
    fun addInTheMiddle() {
        assertEquals(list2.getNode(0)?.data, "a")
        assertEquals(list2.getNode(1)?.data, "b")
        list2.add("x", 1)
        assertEquals(list2.getNode(1)?.data, "x")
        assertEquals(list2.getNode(2)?.data, "b")
        assertThrows(IndexOutOfBoundsException::class.java) {
            list2.getNode(4)?.data
        }
        assertEquals(list2.toString(), "a, x, b, c")
    }

    @Test
    fun addFirst() {
        list2.add("z", 0)
        assertEquals(list2.getNode(0)?.data, "z")
        assertEquals(list2.getNode(1)?.data, "a")
        assertEquals(list2.toString(), "z, a, b, c")
    }

    @Test
    fun addLast() {
        list2.add("r", 3)
        assertEquals(list2.getNode(3)?.data, "r")
        assertThrows(IndexOutOfBoundsException::class.java) {
            list2.getNode(4)?.data
        }
        assertEquals(list2.toString(), "a, b, c, r")
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
        assertThrows(IndexOutOfBoundsException::class.java) {
            assertEquals(list2.getNode(2)?.data, null)
        }
    }

    @Test
    fun removeLast() {
        assertEquals(list2.toString(), "a, b, c")
        list2.remove(2)
        assertEquals(list2.getNode(0)?.data, "a")
        assertEquals(list2.getNode(1)?.data, "b")
        assertThrows(IndexOutOfBoundsException::class.java) {
            list2.getNode(2)?.data
        }
    }

    @Test
    fun addList() {
        list1.add(20)
        list1.add(21)
        list1.add(22)
        list1.addLinkedList(list3)
        assertEquals("20, 21, 22, 10, 11, 12, 13",list1.toString())
        assertEquals(7,list1.size)
    }

    @Test
    fun addListOnIndex() {
        list1.add(20)
        list1.add(21)
        list1.add(22)
        list1.addLinkedList(list3, 1)
        assertEquals("20, 10, 11, 12, 13, 21, 22",list1.toString())
        assertEquals(7,list1.size)
        println(list3)
        list1.addLinkedList(list3, 0)
        assertEquals("10, 11, 12, 13, 20, 10, 11, 12, 13, 21, 22",list1.toString())
        assertEquals(11,list1.size)
        list1.addLinkedList(list3, 11)
        assertEquals("10, 11, 12, 13, 20, 10, 11, 12, 13, 21, 22, 10, 11, 12, 13",list1.toString())
        assertEquals(15,list1.size)
        assertThrows(IndexOutOfBoundsException::class.java) {
            list1.addLinkedList(list3, 22)
        }
    }

}