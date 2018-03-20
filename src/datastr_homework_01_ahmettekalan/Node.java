/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastr_homework_01_ahmettekalan;

/**
 *
 * @author AhmetTekalan
 */
public class Node {
    String rakem;
    Node nextNode;
    String kuvvet;
    public Node(String rakem,String kuvvet) {
       this.kuvvet=kuvvet;
       this.rakem=rakem;
       nextNode=null;
    }
}
