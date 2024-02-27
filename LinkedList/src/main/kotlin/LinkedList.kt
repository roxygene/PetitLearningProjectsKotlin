class LinkedList<T> {
    var head: Node<T>? = null
    var size: Int = 0

    fun get(index: Int): T?{
        return getNode(index)?.data
    }

    fun getNode(index: Int): Node<T>? {
        var counter = 0
            var node = head
        while(counter < index) {
            counter++
            node = node?.next
        }
        return node
    }

    fun add(element: T): Boolean {
        val newNode = Node<T>(element, null)
        if(head == null) {
            head = newNode
        } else {
            var currentNode = head
            while(currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = newNode
        }
        size++
        println("$size")
        return true
    }

    fun add(element: T, index: Int): Boolean{
        if(index == 0) {
            head = Node(element, head)
        } else {
            var node = getNode(index - 1)
            node?.next = Node(element, getNode(index))
        }
        size++
        return true
    }

    fun remove(index: Int): Boolean {
        if(index == 0) {
            head = head?.next
        } else {
            var previousNode = getNode(index - 1)
            previousNode?.next = getNode(index + 1)
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