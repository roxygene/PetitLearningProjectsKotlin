import java.lang.IllegalArgumentException

class DoublyLinkedList<T>(
    var first: Node<T>? = null,
    var last: Node<T>? = null
) {
    var size: Int = 0

    init {
        if (first == null && last == null) {
            size = 0
        } else if (first != null && last == null) {
            size = countTheSizeOfList()
            last = getNode(size - 1)
        } else if (first != null && last != null) {
            size = countTheSizeOfList()
        } else {
            throw IllegalArgumentException("You have to proviede both, first and last.")
        }
    }

    fun countTheSizeOfList(): Int {
        var counter = 0
        if (first == null && last == null) {
            return counter
        }
        counter = 1
        var usedNode: Node<T>?

        if (first != null) {
            usedNode = first
        } else {
            usedNode = last
        }

        if (usedNode == first) {
            while (usedNode?.next != null) {
                counter++
                usedNode = usedNode?.next
            }
        } else if (usedNode == last) {
            while (usedNode?.previous != null) {
                counter++
                usedNode = usedNode?.previous
            }
        }
        return counter
    }

    fun get(index: Int): T? {
        return getNode(index)?.data
    }

    fun getNode(index: Int): Node<T>? {
        val scope = size / 2
        if (index < 0 || index > (size - 1)) {
            throw IndexOutOfBoundsException()
        }
        if (index <= scope) {
            var node = first
            for (i in 0..scope) {
                if (i == index) {
                    return node
                }
                node = node?.next
            }
        } else {
            var node = last
            for (i in size - 1 downTo scope + 1) {
                if (i == index) {
                    return node
                }
                node = node?.previous
            }
        }
        return null
    }

    fun addFirst(element: T) {
        if (first == null) {
            first = Node(element)
            last = first
        } else {
            var newNode = Node(element, null, first)
            first?.previous = newNode
            first = newNode
        }
        size++
    }

    fun addLast(element: T) {
        if (last == null) {
            last = Node(element)
            first = last
        } else {
            var newNode = Node(element, last, null)
            last?.next = newNode
            last = newNode
        }
        size++
    }

    fun add(element: T, index: Int) {
        if (index == 0 && size == 0) {
            addFirst(element)
        } else if (index == size) {
            addLast(element)
        } else {
            var oldNode = getNode(index)
            var newNode = Node(element, oldNode?.previous, oldNode)
            oldNode?.previous?.next = newNode
            oldNode?.previous = newNode
            if (index == 0) {
                first = newNode
            }
            size++
        }

    }

    fun remove(index: Int): Boolean {
        var removedNode = getNode(index)
        var previousNode: Node<T>?
        var nextNode: Node<T>?

        try {
            previousNode = getNode(index - 1)
        } catch (e: java.lang.IndexOutOfBoundsException) {
            previousNode = null
        }

        try {
            nextNode = getNode(index + 1)
        } catch (e: IndexOutOfBoundsException) {
            nextNode = null
        }

        previousNode?.next = nextNode
        nextNode?.previous = previousNode

        if (removedNode == first) {
            first = nextNode
        }

        if (removedNode == last) {
            last = previousNode
        }
        size--
        return true
    }

    override fun toString(): String {
        var result = ""
        var node = first
        result += node?.data ?: ""

        while (node?.next != null) {
            node = node?.next
            result += ", " + node?.data?.toString()

        }
        return result
    }

}