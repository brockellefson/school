/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg338graph;

import java.util.LinkedList;

/**
 *
 * @author brock
 */
public class Graph {
    
public LinkedList<Node> graph;

    public Graph(){
        graph = new LinkedList<Node>();
    }

    public void addCity(String city){
        if(graph.size() == 0){
            Node newNode = new Node();
            newNode.city = city;
            graph.add(newNode);            
        }       
        else if(!graph.getLast().city.equals(city)){    
            Node newNode = new Node();
            newNode.city = city;
            graph.add(newNode);
        }
        
    }

    public void addEdge(String start, String end, int weight){
        Edge newEdge = new Edge(start, end, weight);
        for(int i = 0; i < graph.size(); i ++){
            if(graph.get(i).city.equals(start)){
                graph.get(i).AdjacencyList.add(newEdge);
            }
        }
    }
}


