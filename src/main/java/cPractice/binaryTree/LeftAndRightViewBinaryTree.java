package cPractice.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftAndRightViewBinaryTree {
   TreeNode root;
    LeftAndRightViewBinaryTree(){
        root=null;
    }

    static void leftView(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int k=queue.size();
           for(int i=1; i<=k ;i++) {
               TreeNode temp=queue.poll();
               if (i == 1)
                   System.out.print(temp.value +" ");
               if (temp.left != null)
                   queue.add(temp.left);
               if (temp.right != null)
                   queue.add(temp.right);
           }
        }
    }

    static void rightView(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int k=queue.size();
            for(int i=1; i<=k ;i++) {
                TreeNode temp=queue.poll();
                if (i == k)
                    System.out.print(temp.value+" ");
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {

        LeftAndRightViewBinaryTree tree = new LeftAndRightViewBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Left view is:");
        leftView(tree.root);
        System.out.println();
        System.out.println("Right view is:");
        rightView(tree.root);
    }
}
