import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.lang.IndexOutOfBoundsException

class DoublyLinkedListTest {
    private lateinit var list1: DoublyLinkedList<Int>
    private lateinit var list2: DoublyLinkedList<Int>
    private lateinit var list3: DoublyLinkedList<String>
    private lateinit var node1: Node<Int>
    private lateinit var node2: Node<Int>
    private lateinit var node3: Node<Int>
    private lateinit var node4: Node<Int>

    @BeforeEach
    fun setUp() {
        list1 = DoublyLinkedList()
        list2 = DoublyLinkedList()
        list3 = DoublyLinkedList()
        list2.addLast(10)
        list2.addLast(11)
        list2.addLast(12)
        list3.addFirst("x")
        node1 = Node(1,null, null)
        node2 = Node(2,null, null)
        node3 = Node(0,null, null)
        node3.next = Node(1,node3, null)
        node3.next?.next = Node(2,node3.next, null)
        node4 = node3.next?.next!!

    }

    @Test
    fun countTheSizeOfList() {
        assertEquals(0, list1.countTheSizeOfList())
        assertEquals(3, list2.countTheSizeOfList())
        assertEquals(1, list3.countTheSizeOfList())

    }
    
    @Test
    fun createEmptyList() {
        var list4 = DoublyLinkedList<Int>()
        assertEquals("", list4.toString())
        assertEquals(0, list4.size)
    }

    @Test
    fun createListWithTwoNodes() {
        var list = DoublyLinkedList(node3, node4)
        assertEquals("0, 1, 2", list.toString())
        assertEquals(3, list.size)
        var listx = DoublyLinkedList(node1, node1)
        assertEquals("1", listx.toString())
        assertEquals(1, listx.size)
    }


    @Test
    fun addFirst() {
        list1.addFirst(1)
        assertEquals("1", list1.toString())
        list2.addFirst(2)
        assertEquals("2, 10, 11, 12", list2.toString())
        assertEquals(1, list1.size)
        assertEquals(4, list2.size)
    }

    @Test
    fun addLast() {
        list1.addLast(0)
        assertEquals("0", list1.toString())
        list2.addLast(13)
        assertEquals("10, 11, 12, 13", list2.toString())
    }

    @Test
    fun addSuccesfull() {
        list1.add(10, 0)
        assertEquals("10", list1.toString())
        assertEquals(1, list1.size)
        assertEquals(3, list2.size)
        list2.add(100, 0)
        assertEquals("100, 10, 11, 12", list2.toString())
        assertEquals(4, list2.size)
        list2.add(20, 3)
        assertEquals("100, 10, 11, 20, 12", list2.toString())
        assertEquals(5, list2.size)
        list2.add(22, 5)
        assertEquals("100, 10, 11, 20, 12, 22", list2.toString())
        assertEquals(6, list2.size)
    }

    @Test
    fun addFailed() {
        assertThrows(IndexOutOfBoundsException::class.java) {
            list1.add(100, 1)
            list1.add(100, -1)
            list2.add(100, -1)
            list2.add(100, 4)
        }
    }

    @Test
    fun get() {
        assertEquals(11, list2.get(1))
        assertThrows(IndexOutOfBoundsException::class.java) {
            list2.get(3)
            list1.get(1)
            list1.get(0)
        }
    }

    @Test
    fun getNode() {
        assertEquals(10, list2.getNode(0)?.data)
        assertEquals(11, list2.getNode(1)?.data)
        assertEquals(12, list2.getNode(2)?.data)
        assertThrows(IndexOutOfBoundsException::class.java) {
            list1.getNode(0)
            list2.getNode(-1)
            list2.getNode(3)
        }
    }

    @Test
    fun remove() {
        list2.remove(1)
        assertEquals("10, 12", list2.toString())
        assertEquals(2, list2.size)
    }

    @Test
    fun removeFirstAndLast() {
        list2.remove(0)
        assertEquals("11, 12", list2.toString())
        assertEquals(2, list2.size)
        list2.remove(1)
        assertEquals("11", list2.toString())
        assertEquals(1, list2.size)
        list3.remove(0)
        assertEquals("", list3.toString())
        assertEquals(0, list3.size)
    }

    @Test
    fun removeFailed() {
        assertThrows(IndexOutOfBoundsException::class.java) {
            list2.remove(3)
            list1.remove(0)
            list3.remove(1)
            list2.remove(-1)
        }
    }

}