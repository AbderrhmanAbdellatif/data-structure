/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj1;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author EXT02D6270
 */
public class HashTable<T, G> {

    private HashEntry<T, G>[] table;
    public ArrayList<BST> tree = new ArrayList();
    public HashTable(int capacity) {
        table = new HashEntry[capacity];
    }
    void put(T key, G value) {
        int hashResult = hashFunction(key);
        int index = hashResult % table.length;
        int indexofkey;
        if (table[index] == null) {
            table[index] = new HashEntry<>(key, value);
            BST bst = new BST();
            bst.keyofindex = (Integer) key;
            bst.insert(value.toString());
            tree.add(bst);
        } else {   // table indexi boş ise ekleyecek boş değilse tree oluşacak
            indexofkey = (Integer) key;
            for (int i = 0; i < tree.size(); i++) {
                if (Objects.equals((Integer) tree.get(i).keyofindex, (Integer) indexofkey)) {
                    tree.get(i).insert((String) value);
                    break;
                }
            }

        }

    }

    private int hashFunction(T key) {
        // returns last digit of the given key(for integer)
        String value = String.valueOf(key);
        int parseInt = Integer.parseInt("" + value.charAt(value.length() - 1));
        return parseInt;
    }
}
