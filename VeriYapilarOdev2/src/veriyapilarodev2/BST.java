/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veriyapilarodev2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Aizen
 * @param <T>
 */
public class BST<T extends Comparable<T>> {
    // linkedlist<String> Linkedlist = new linkedlist<>();

    private Node<T> root;
    String Nodeler = " ";

    void addthewordtoBST(String x) throws FileNotFoundException {
        File f = new File(x);
        Scanner input = new Scanner(f);
        while (input.hasNext()) {
            String str = input.next();
            insertRecursive((T) str);
        }
    }

    void insertRecursive(T newData) {
        root = insertRecursive(root, newData);
    }

    private Node<T> insertRecursive(Node<T> n, T newData) {
        if (n == null) {
            n = new Node<>(newData);
        } else {
            if (newData.compareTo(n.data) > 0) {
                n.rightChild = insertRecursive(n.rightChild, newData);
            } else if (newData.compareTo(n.data) < 0) {
                n.leftChild = insertRecursive(n.leftChild, newData);
            }
        }

        return n;
    }

    void inorder() {
        inorder(root);
        System.out.println();
    }

    void inorder(Node<T> n) {
        if (n != null) {
            inorder(n.leftChild);
            Nodeler += n.data + " ";
            inorder(n.rightChild);
        }
    }
}
