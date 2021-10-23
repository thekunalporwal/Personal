package cPractice.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    TreeNode root;

    LevelOrderTraversal() {
        root = null;
    }

    static void levelOrder(TreeNode node){

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.value +" ");
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
    }

    // Driver method
    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

      levelOrder(tree.root);
    }
}
