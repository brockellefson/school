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
    
public LinkedList<Tree> graph = new LinkedList<Tree>();

/** To create a weighted graph I made a linked list of trees
 *  The root of each tree is the start city, and each child will be the end city
 *  The child will contain the weight between the two cities
 */


    public void addCity(String city){
        if(graph.isEmpty()){ //if main list is empty
            graph.add(new Tree(city));//insert node in the first element of the first linked list
        }       
        else if(!graph.getLast().root.city.equals(city)){ //main list is not empty 
             graph.add(new Tree(city)); //add a new tree to tree list
        }
        
    }

    public void addEdge(String start, String end, int weight){
        for(int i = 0; i < graph.size(); i ++){
            if(graph.get(i).root.city.equals(start)){ //iterate through linked list until we find the city we want to add an edge to
                Node edge = new Node(end, weight); //create new node for city
                graph.get(i).root.children.add(edge); //add data to tree
            }
        }
    }
    

}


