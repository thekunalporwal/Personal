package cPractice.binaryTree;

public class InvertBinaryTree {
    TreeNode root;
    InvertBinaryTree(){root=null;}

    static TreeNode invertTree(TreeNode node){
        }

    public static void main(String[] args) {

        InvertBinaryTree tree = new InvertBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
    }
}
