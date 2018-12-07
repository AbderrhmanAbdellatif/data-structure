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
public class Nodeq <T>{
    
    T data;
    Nodeq<T> next;
    public Nodeq(T data) {
       this.data = data;
       next = null;
    }
    
    
}