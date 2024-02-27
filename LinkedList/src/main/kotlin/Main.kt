fun main(args: Array<String>) {
    var list = LinkedList<Int>()
    list.add(0)
    list.add(1)
    list.add(2)
    println(list)
    list.add(5, 1)
    println(list)
    var list1 = LinkedList<String>()
    list1.add("a")
    list1.add("b")
    list1.add("c")
    println(list1)
    list1.add("s", 1)
    println(list1)

}