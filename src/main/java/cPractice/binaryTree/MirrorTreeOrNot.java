package cPractice.binaryTree;

public class MirrorTreeOrNot {
    TreeNode root;
    MirrorTreeOrNot(){root=null;}

    static boolean mirrorTree(TreeNode node1, TreeNode node2){

        if(node1==null && node2==null)
            return true;

        if(node1==null || node2==null)
            return false;

        return (node1.value==node2.value)&& mirrorTree(node1.left,node2.right)&&mirrorTree(node1.right,node2.left);

    }

    public static void main(String[] args) {

        MirrorTreeOrNot tree = new MirrorTreeOrNot();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        MirrorTreeOrNot tree2 = new MirrorTreeOrNot();
        tree2.root = new TreeNode(1);
        tree2.root.left = new TreeNode(3);
        tree2.root.right = new TreeNode(2);
        tree2.root.right.left = new TreeNode(5);
        tree2.root.right.right = new TreeNode(4);

        System.out.println("Both are mirror tree: "+mirrorTree(tree.root, tree2.root));
    }
}
