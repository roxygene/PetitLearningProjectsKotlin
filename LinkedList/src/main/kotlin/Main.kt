fun main(args: Array<String>) {
    var list0 = LinkedList<Int>()
    list0.add(0)
    list0.add(1)
    list0.add(2)
    println(list0)
    println("size ${list0.size}")
    list0.add(5, 1)
    println(list0)
    println("size ${list0.size}")

    val node1 = Node(10, null)
    var list1 = LinkedList(node1)
    list1.add(11)
    list1.add(12)
    println(list1)
    println("size ${list1.size}")

    var list2 = LinkedList(node1)
    list2.add(20)
    list2.add(21)
    println(list2)
    println("size ${list2.size}")
    println(list1)
    println("size ${list1.size}")
    list2.addLinkedList(list0)
    println("size ${list2.size}")
}