class LinkedList<T>(var head: Node<T>? = null) {
    var size: Int = 0

    constructor(list: LinkedList<T>) : this() {
        var node: Node<T>? = list.head
        while (node != null) {
            add(node.data)
            node = node.next
        }
    }

    init {
        if (head != null) {
            size = countTheSizeOfList(head)
        }
    }

    fun countTheSizeOfList(firstNode: Node<T>?): Int {
        if(firstNode == null) {
            return 0
        }
        var counter = 1
        var node = firstNode
        while (node?.next != null) {
            counter++
            node = node?.next
        }
        return counter
    }


    fun get(index: Int): T? {
        return getNode(index)?.data
    }

    fun getNode(index: Int): Node<T>? {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }
        var counter = 0
        var node = head
        while (counter < index) {
            counter++
            node = node?.next
        }
        return node
    }

    fun add(element: T): Boolean {
        val newNode = Node<T>(element, null)
        if (head == null) {
            head = newNode
        } else {
            var currentNode = head
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = newNode
        }
        size++
        return true
    }

    fun add(element: T, index: Int): Boolean {
        if (index == 0) {
            head = Node(element, head)
            size++
        } else if (index == size) {
            add(element)
        } else {
            var node = getNode(index - 1)
            node?.next = Node(element, getNode(index))
            size++
        }
        return true
    }

    fun addLinkedList(newList: LinkedList<T>): Boolean {
        val headOfNewList = newList.head
        val sizeOfNewList = newList.countTheSizeOfList(headOfNewList)
        if (head == null) {
            head = headOfNewList
        } else {
            var currentNode = head
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = headOfNewList
        }
        size += sizeOfNewList
        return true
    }
    fun addLinkedList(list: LinkedList<T>, index: Int): Boolean {
        if(index < 0 || index > size) {
            throw IndexOutOfBoundsException()
        }

        val newList = LinkedList(list)
        val headOfNewList = newList.head
        val sizeOfNewList = newList.countTheSizeOfList(headOfNewList)
        var lastNodeOfNewList = newList.getNode(sizeOfNewList - 1)
        if (index == 0) {
            val oldHead = head
            head = headOfNewList
            lastNodeOfNewList?.next = oldHead
            size += sizeOfNewList
        } else if (index == size) {
            addLinkedList(newList)
        } else {
            var previousNode = getNode(index - 1)
            var node = getNode(index)
            previousNode?.next = headOfNewList
            lastNodeOfNewList?.next = node
            size += sizeOfNewList
        }
        return true
    }

    fun remove(index: Int): Boolean {
        if (index == 0) {
            head = head?.next
        } else {
            var previousNode = getNode(index - 1)
            try {
                previousNode?.next = getNode(index + 1)
            } catch (e: java.lang.IndexOutOfBoundsException) {
                previousNode?.next = null
            }

            var node = getNode(index)
            node?.next = null
        }
        size--
        return true

    }

    override fun toString(): String {
        var currentNode = head
        var result = "${currentNode?.data}"
        while (currentNode?.next != null) {
            currentNode = currentNode.next
            result += ", ${currentNode?.data}"
        }
        return result
    }


}