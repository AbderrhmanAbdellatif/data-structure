/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veriyapilarodev2;

/**
 *
 * @author Aizen
 * @param <mytype>
 */
public class NodeLL <mytype> {
     mytype value;
     NodeLL<mytype> next;
    public NodeLL(mytype value) {
        this.value = value;
        this.next = null;
    }
     
}
