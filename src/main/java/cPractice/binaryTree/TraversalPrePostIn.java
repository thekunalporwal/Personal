package cPractice.binaryTree;

public class TraversalPrePostIn {

    TreeNode root;
    TraversalPrePostIn(){ root = null; }

    public static void preOrder(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);

    }

    public static void postOrder(TreeNode node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");

    }

    public static void InOrder(TreeNode node){
        if(node==null)
            return;
        InOrder(node.left);
        System.out.print(node.value+" ");
        InOrder(node.right);

    }

    // Driver method
    public static void main(String[] args) {
        TraversalPrePostIn tree = new TraversalPrePostIn();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        preOrder(tree.root);
        System.out.println();
        postOrder(tree.root);
        System.out.println();
        InOrder(tree.root);


    }
}
