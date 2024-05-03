import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class TreeNodeTest {
    val rootA : TreeNode<String> = TreeNode("A")
    val nodeB : TreeNode<String> = TreeNode("B")
    val nodeC : TreeNode<String> = TreeNode("C")
    val nodeD : TreeNode<String> = TreeNode("D")
    val nodeE : TreeNode<String> = TreeNode("E")
    val nodeF : TreeNode<String> = TreeNode("F")
    val nodeG : TreeNode<String> = TreeNode("G")
    val nodeH : TreeNode<String> = TreeNode("H")

    fun setUp() {
        rootA.addChild(nodeB)
        rootA.addChild(nodeC)
        nodeB.addChild(nodeD)
        nodeD.addChild(nodeE)
        nodeD.addChild(nodeF)
        nodeC.addChild(nodeG)
        nodeC.addChild(nodeH)
    }

    @Test
    fun addChildTest() {
        assertEquals("", rootA.children())
        rootA.addChild(nodeB)
        assertEquals("B ", rootA.children())
        rootA.addChild(nodeC)
        assertEquals("B C ", rootA.children())
        nodeC.addChild(nodeD)
        assertEquals("D ", nodeC.children())
    }

    @Test
    fun recursiveDFSTest() {
        setUp()
        assertEquals("A, B, D, E, F, C, G, H, ", rootA.recursiveDFS())
        assertEquals("D, E, F, ", nodeD.recursiveDFS())
    }

}