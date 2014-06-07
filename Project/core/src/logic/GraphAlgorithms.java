/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import Libraries.Node;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nicolas
 */

public class GraphAlgorithms {
    private static GraphAlgorithms instance  =  null;
    //private HashTable _nodosHash;
    private ArrayList<Node> _VisitedList; // Dejaremos el tamano maximo en 30
    
    private static final int PROBABILITY_TO_RECOMMEND = 40;
    private static final int LIST_MAX_SIZE = 30;
    
    protected GraphAlgorithms(){
        //_nodosHash = new HashTable();
        _VisitedList = new ArrayList<Node>();
    }
    
    public static GraphAlgorithms getInstance(){
        if(instance == null) {
         instance = new GraphAlgorithms();
      }
      return instance;
    }
    
    public boolean wasNodeVisited(Node pNode){
        
        try{
            if(pNode.getNodesList().isEmpty()){
                this.generateIntersections(pNode);
            }
            for(int trail = 0; trail < _VisitedList.size(); trail++){
                if(this.isGeneratedBackwards(_VisitedList.get(trail), pNode)){
                    //pNode.setVisited(true);
                    System.out.println("Esta buscando si se puede generar desde la lista");
                    return true;
                }
            }
            // si llega aqui significa que no ha sido visitado
            for(int trail = 0; trail < _VisitedList.size(); trail++){
                if(this.isGeneratedBackwards( pNode, _VisitedList.get(trail))){
                    _VisitedList.remove(trail); // Lo eliminamos porque ya estamos por encima de el
                }
            }
            // Si llega aqui es porque es un camino nuevo
            // Osea que el noddo anterior no estaba en la lista, y tampoco este ha sido visitado
            if(_VisitedList.size() < LIST_MAX_SIZE){
                _VisitedList.add(pNode);
            }else{
                Random random = new Random();
                int randNumber = random.nextInt()%_VisitedList.size();
                _VisitedList.remove(randNumber);
                _VisitedList.add(pNode);
            }
            pNode.setNodesList(new ArrayList<Node>());
            return false;
        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean isGeneratedBackwards(Node initialNode, Node nodeToFind){
        try{
            if(initialNode.getLevel() <  nodeToFind.getLevel())
                return false;
            
            Node recorrido = new Node(initialNode.getSeed(),initialNode.getLevel());
            while(recorrido.getLevel() != nodeToFind.getLevel()){
                double newSeed = (double)Math.ceil(recorrido.getSeed() / 3);
                recorrido.setSeed(newSeed);
                recorrido.setLevel(recorrido.getLevel()-1);
                System.out.println("ESTOY ENCICLADO");
            }
            if(recorrido.getSeed() == nodeToFind.getSeed()){
                return true;
            }
            return false;
        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    public void generateIntersections(Node node){
        try{
            int cantNext = cantNodesSiguientes(node.getSeed());
            double seedInicial = ((node.getSeed() - 1)*3)+1;
            for(int numNodo = 0; numNodo < cantNext; numNodo++){
                Node nuevoNodo = new Node(seedInicial,node.getLevel()+1);
                node.getNodesList().add(nuevoNodo);
                seedInicial++;
            }

            if(node.getSeed()%5 == 0 && node.getLevel()%4 == 0){ //Esto es que si es multiplo de 5, tiene uno que se devuelve
                int replacePos = node.getNodesList().size() -1;
                node.getNodesList().remove(replacePos);
                node.getNodesList().add(replacePos, generateDevolution(node));
                //node.getNodesList().add(generateDevolution(node));

            }
        }catch(Exception e){
            System.out.println(e.toString());
        }

    }
    
    
    private Node generateDevolution(Node node){
        try{
            double newSeed = node.getSeed();
            int newLevel = node.getLevel();
            for(int dev = 0; dev < (int)(node.getSeed()%4)+1; dev++){
                newSeed = (double)Math.ceil(newSeed / 3);
                newLevel -= 1;
            }
            return new Node(newSeed,newLevel);
        }catch(Exception e){
            System.out.println(e.toString());
            return new Node(1,1);
        }
    }
    
    
    public int cantNodesSiguientes(double seed){
        try{
            if(seed % 3 == 0)
                return 1;
            if(seed % 2 == 0)
                 return 2;
            else
                return 3;
        }catch(Exception e){
            System.out.println(e.toString());
            return 2;
        }
    }
    
    public int getRecommendedPath(Node pNode){ //Algritmo voraz que decide el camino
        try{
            int probability = Math.abs(new Random().nextInt()) % 100;//Es 100 por se un porcentaje
            
            if(probability < PROBABILITY_TO_RECOMMEND){
                    Node node = new Node(pNode.getSeed(),pNode.getLevel());
                
                    generateIntersections(node);
                    ArrayList<Node> nextNodesList = node.getNodesList();
                    for(int nodesIndex = 0; nodesIndex < nextNodesList.size(); nodesIndex++){
                        GraphAlgorithms.getInstance().generateIntersections(nextNodesList.get(nodesIndex));
                    }
                    Node ptr = nextNodesList.get(0);
                    for(int index = 0; index < nextNodesList.size(); index++){
                        if(nextNodesList.get(index).getNodesList().size() > ptr.getNodesList().size()){
                            ptr = nextNodesList.get(index);
                        }
                    }
                    return nextNodesList.indexOf(ptr); // Retorna si debe elegir el primer, segundo o tercer camino
            }else{
                return -1;
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
            return 0;
        }
    }
    
    public Node getInitialNode(){
        return new Node(1,1);
    }
    
    
}
