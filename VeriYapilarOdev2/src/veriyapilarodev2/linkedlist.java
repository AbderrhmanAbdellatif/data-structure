/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veriyapilarodev2;

/**
 *
 * @author Aizen
 * @param <MyType>
 */
public class linkedlist<MyType> {

    NodeLL<MyType> head;

    void addFirst(MyType newNode) {
        NodeLL newNodell = new NodeLL(newNode);
        if (head == null) {
            head = newNodell;
        } else {
            newNodell.next = head;
            head = newNodell;
        }
    }
 public int size() {
        int counter = 0;

        NodeLL temp = head;

        while (temp != null) {
            counter++;
            temp = temp.next;
        }

        return counter;
    }

}
