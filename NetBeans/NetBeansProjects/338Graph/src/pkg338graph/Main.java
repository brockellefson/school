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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;


public class Main {

	private static final String file = "city.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Graph graph = new Graph();
            
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int limit = 0; //first 20 cities
        while((line = br.readLine()) != null && limit < 1200) {
            limit++;
           // System.out.println(line);
            String lines[] = line.split("  +");
           //System.out.println("LOG: [0] " + lines[0] + " [1]: " + lines[1] + " [2]: " + lines[2]);
            graph.addCity(lines[0]);
            lines[2] = lines[2].replace(" ", "");
            Integer weight = Integer.valueOf(lines[2]);
            graph.addEdge(lines[0], lines[1], weight);
        
        }
        SteinerTree sTree = new SteinerTree(graph.graph);
        
    }
        
        
        
}

		