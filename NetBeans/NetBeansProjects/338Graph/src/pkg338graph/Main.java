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
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;


public class Main {

	private static final String file = "city.txt";

	public static void main(String[] args) {

		BufferedReader br = null;
		FileReader fr = null;
                Graph graph = new Graph();
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
                                String line[] = sCurrentLine.split(" ");
                                graph.addCity(line[0]);
                               // graph.addEdge(line[0], line[1], line[3]);
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}