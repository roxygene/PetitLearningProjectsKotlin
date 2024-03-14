import java.lang.IllegalArgumentException

class Node<T>(var data: T, var next: Node<T>? = null) {
    init {
        if (data == null) {
            throw IllegalArgumentException("Data of element can't be null.")
        }
    }

}