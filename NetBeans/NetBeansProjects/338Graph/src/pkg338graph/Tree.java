/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg338graph;

import java.util.ArrayList;

/**
 *
 * @author brock
 */
public class Tree<T> {
    public Node root;

    public Tree(String city) {
        root = new Node(city, 0); //the root of each city will have a distance of 0 to itself
        root.children = new ArrayList<Node>(); //all children and weights
    }
}