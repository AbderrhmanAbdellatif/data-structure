/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj1;

/**
 *
 * @author EXT02D6270
 */
public class Node<T extends Comparable<T>> {

    T data;
    Node<T> leftChild;
    Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }
}
