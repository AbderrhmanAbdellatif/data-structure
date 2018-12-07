/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj1;

/**
 *
 * @author 14mst
 */
public class MyQueue<T> {
    
    // add last -  remove first
    Nodeq<T> head;
    int size = 0;
    void enqueue(T data){
        Nodeq<T> newNode= new Nodeq<>(data);
        Nodeq<T> temp = head;
                
        if (head == null){
            head = newNode;
            size++;
        }else{
            while(temp.next != null){
                temp = temp.next;
            }
            size++;
            temp.next = newNode;
        }
        
    }
    T dequeue(){
        T data = head.data;
        if (head.next == null){
            head = null;
            size--;
            return data;            
        }else{
            head = head.next;
            size--;
            return data;
        }          
        
    }
    boolean isEmpty(){
        
        if (size == 0){
            return true;
        }
        else
            return false;
        
    }
    
    T queueFront(){
        
        return head.data;
    }
    
    
}
