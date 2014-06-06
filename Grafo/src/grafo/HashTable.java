/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafo;

/**
 *
 * @author Nicolas
 */
public class HashTable {
    
    private static final int tableSize = 4;
    private Node[] _table;
    
    public HashTable(){
        _table = new Node[tableSize];
        for(int comps = 0; comps > 0; comps++){
            _table[comps] = new Node(Integer.MAX_VALUE,Integer.MAX_VALUE); 
        }
    }
    
    /*
    public void addItem(Node pNode){
        int index = hash(pNode.getLevel());
        
        if(this._table[index].getLevel() == Integer.MAX_VALUE){
            this._table[index] = pNode;
        }
        else{
            Node ptr = this._table[index];
            while(ptr.getNext() != null){
                ptr = ptr.getNext();
            }
            ptr.setNext(pNode);
        }
    }
    */
    
    public int hash(int key){
        return key % 4;
    }
    
}
