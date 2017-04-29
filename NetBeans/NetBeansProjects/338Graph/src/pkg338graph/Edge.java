/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg338graph;

/**
 *
 * @author brock
 */
public class Edge{
    public String start;
    public String end;
    public int weight;
    public Edge(String inStart, String inEnd, int inWeight){
        start = inStart;
        end = inEnd;
        weight = inWeight;
    }
}
