/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj1;

/**
 *
 * @author 14mst
 * @param <T>
 */
public class BST<T extends Comparable<T>> {

    Node<T> root;
    MyQueue<Node> myqueue = new MyQueue<>();
    int keyofindex;
    void insert(T newData) {
        Node<T> newNode = new Node<>(newData);

        if (root == null) {
            root = newNode;
        } else {
            Node<T> temp = root;

            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) { // sağ
                    if (temp.rightChild == null) {   // sağ çocuk olarak ekle
                        temp.rightChild = newNode;
                        return;
                    }

                    temp = temp.rightChild;
                } else if (newData.compareTo(temp.data) < 0) {    // sol
                    if (temp.leftChild == null) {   // sol çocuk olarak ekle
                        temp.leftChild = newNode;
                        return;
                    }

                    temp = temp.leftChild;
                } else {    // aynı veriyi eklemek istemiyoruz
                    return;
                }
            }
        }
    }

    void levelOrderTraversal() {
        Node tempNode = root;
        myqueue.enqueue(root);
        while (!myqueue.isEmpty()) {
            tempNode = myqueue.dequeue();
            main.txtAreaTraverse.append(tempNode.data.toString() + " - ");
            if (tempNode.leftChild != null) {
                myqueue.enqueue(tempNode.leftChild);
            }
            if (tempNode.rightChild != null) {
                myqueue.enqueue(tempNode.rightChild);
            }
        }

    }
    public void display(Node n) {
        
        if (n == null) {
            return;
        }
        display(n.leftChild);
        System.out.print("  ["+n.data+"] --> ");
        
        display(n.rightChild);
    }
   
    public void preorder(Node<T> n) {
        if (n != null) {
            main.txtAreaTraverse.append(n.data.toString() + " -> ");
            preorder(n.leftChild);
            preorder(n.rightChild);
        }
    }

    public void postorder(Node<T> r) {
        if (r != null) {
            postorder(r.leftChild);
            postorder(r.rightChild);
            main.txtAreaTraverse.append(r.data.toString() + " -> ");
        }
    }

    public void inorder(Node<T> r) {
        if (r != null) {
            inorder(r.leftChild);
            main.txtAreaTraverse.append(r.data.toString() + " -> ");
            inorder(r.rightChild);
        }
    }

}
