/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class Node {
    
    private boolean _visited;
    private double _seed;
    private int _level;
    private ArrayList<Node> _NodesList;
    
    public Node(double pSeed, int pLevel){
        this._visited = false;
        this._seed = pSeed;
        this._level = pLevel;
        this._NodesList = new ArrayList<Node>();
    }
    
    

    public boolean isVisited() {
        return _visited;
    }

    public void setVisited(boolean _visited) {
        this._visited = _visited;
    }

    public double getSeed() {
        return _seed;
    }

    public void setSeed(double _seed) {
        this._seed = _seed;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int _level) {
        this._level = _level;
    }

    public ArrayList<Node> getNodesList() {
        return _NodesList;
    }

    public void setNodesList(ArrayList<Node> _NodesList) {
        this._NodesList = _NodesList;
    }
    
}