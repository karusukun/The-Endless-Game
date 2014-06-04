/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafo;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Nicolas
 */
public class Graph { // ESTA CLASE NO VA A UTILIZARSE FINALMENTE
    
    private ArrayList<Node> _vertices;
    private Node _CurrentNode;
    
    public Graph(){
        this._vertices = new ArrayList<Node>();
    }
    
    public void addNode (Node pNode){
        this._vertices.add(pNode);
    }

    public Node getCurrentNode() {
        return _CurrentNode;
    }

    public void setCurrentNode(Node _CurrentNode) {
        this._CurrentNode = _CurrentNode;
    }

    public ArrayList<Node> getVertices() {
        return _vertices;
    }

    public void setVertices(ArrayList<Node> _vertices) {
        this._vertices = _vertices;
    }
        
}
