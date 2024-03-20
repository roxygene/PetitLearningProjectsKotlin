import java.lang.IllegalArgumentException

class Node<T>(var data: T, var previous: Node<T>? = null, var next: Node<T>? = null) {
    init {
        if (data == null) {
            throw IllegalArgumentException("Data of element can't be null.")
        }
    }

}