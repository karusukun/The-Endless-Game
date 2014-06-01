/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafo;

import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */

public class GraphAlgorithms {
    private static GraphAlgorithms instance = null;
    private HashTable _nodosHash;
    
    protected GraphAlgorithms(){
        _nodosHash = new HashTable();
    }
    
    public static GraphAlgorithms getInstance(){
        if(instance == null) {
         instance = new GraphAlgorithms();
      }
      return instance;
    }
    
    public void generateIntersections(Node node){
        int cantNext = cantNodesSiguientes(node.getSeed());
        double seedInicial = ((node.getSeed() - 1)*3)+1;
        for(int numNodo = 0; numNodo < cantNext; numNodo++){
            Node nuevoNodo = new Node(seedInicial,node.getLevel()+1);
            node.getNodesList().add(nuevoNodo);
        }
        
    }
    
    public int cantNodesSiguientes(double seed){
        if(seed % 3 == 0)
            return 1;
        if(seed % 2 == 0)
             return 2;
        else
            return 3;
    }
    
    public int getRecommendedPath(ArrayList<Node> nextNodesList){ //Algritmo voraz que decide el camino
        for(int nodesIndex = 0; nodesIndex < nextNodesList.size(); nodesIndex++){
            GraphAlgorithms.getInstance().generateIntersections(nextNodesList.get(nodesIndex));
        }
        Node ptr = nextNodesList.get(0);
        for(int index = 0; index < nextNodesList.size(); index++){
            if(nextNodesList.get(index).getNodesList().size() > ptr.getNodesList().size()){
                ptr = nextNodesList.get(index);
            }
        }
        return nextNodesList.indexOf(ptr);
    }
    
    private int sizeTransitiveClosure(Node pNode){
        return 0;
    }
    
    
}
