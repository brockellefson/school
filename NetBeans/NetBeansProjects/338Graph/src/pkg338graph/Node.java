/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg338graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brock
 */
public class Node{
    public String city; //city name
    public int weight; //weight to parent
    public List<Node> children;

    public Node(String inCity, int inWeight){
        city = inCity;
        weight = inWeight;
    }
}
