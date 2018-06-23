package org.hashtable;

public class TestHashTable {
    public static void main(String[] args) {
        HashTable ht = new HashTable(11);
        ht.insert(80);
        ht.insert(40);
        ht.insert(65);
        ht.show();
        ht.insert(58);
        ht.insert(24);
        ht.show();
        ht.insert(35);
        ht.show();
        ht.remove(58);
        ht.show();
        ht.insert(48);
        ht.show();
    }
}
