class TreeNode<T>(val value: T) {
    var children : MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(child : TreeNode<T>) {
        children.add(child)
    }

    fun children() : String{
        var childrenString = ""
        children.forEach { child -> childrenString += child.value.toString() + " "}
        return childrenString
    }

    fun recursiveDFS(): String {
        var result = "${this.value}, "
        if(children.isNotEmpty()) {
            for(n : TreeNode<T> in children) {
                result += n.recursiveDFS()
            }
        }
        return result
    }


}