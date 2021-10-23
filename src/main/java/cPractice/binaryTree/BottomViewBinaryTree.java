package cPractice.binaryTree;

import java.util.*;

public class BottomViewBinaryTree {
    BottomNode root;

    BottomViewBinaryTree() {
        root = null;
    }
//
//    static void bottomView(TreeNode node) {
//       root=node;
//    }

    public static void bottomViewCall(BottomNode root){

      if(root==null)
          return;

        Map<Integer,Integer> treemap=new TreeMap<>();
        int distance=0;
        root.hd=0;
        Queue<BottomNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BottomNode temp=queue.poll();
            treemap.put(temp.hd, temp.data);

            if(temp.left!=null){
                temp.left.hd= temp.hd-1 ;
                queue.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd= temp.hd+1 ;
                queue.add(temp.right);
            }
        }

        List<Map.Entry<Integer,Integer>> list=new LinkedList<>(treemap.entrySet());
        list.stream().forEach(e2 ->{
            System.out.print(e2.getValue()+" ");
        });


    }

    public static void TopViewCall(BottomNode root){

        if(root==null)
            return;

        Map<Integer,Integer> treemap=new TreeMap<>();
        int distance=0;
        root.hd=0;
        Queue<BottomNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BottomNode temp=queue.poll();

            if(treemap.get(temp.hd)==null)
            treemap.put(temp.hd, temp.data);

            if(temp.left!=null){
                temp.left.hd= temp.hd-1 ;
                queue.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd= temp.hd+1 ;
                queue.add(temp.right);
            }
        }

        List<Map.Entry<Integer,Integer>> list=new LinkedList<>(treemap.entrySet());
        list.stream().forEach(e2 ->{
            System.out.print(e2.getValue()+" ");
        });


    }

    public static void main(String[] args) {

        BottomViewBinaryTree tree = new BottomViewBinaryTree();
        tree.root = new BottomNode(20);
        tree.root.left = new BottomNode(8);
        tree.root.right = new BottomNode(22);
        tree.root.left.left = new BottomNode(5);
        tree.root.left.right = new BottomNode(3);
        tree.root.right.left = new BottomNode(4);
        tree.root.right.right = new BottomNode(25);
        tree.root.left.right.left = new BottomNode(10);
        tree.root.left.right.right = new BottomNode(14);


        bottomViewCall(tree.root);
        System.out.println();
        TopViewCall(tree.root);

    }
}

class BottomNode{
    int data;
    int hd;
    BottomNode left;
    BottomNode right;

    BottomNode(int value){
        data=value;
        left=right=null;
        hd=Integer.MAX_VALUE;
    }
}