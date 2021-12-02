//GraphGenerator.java

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class GraphGenerator {
	private static ArrayList<String> output = new ArrayList<String>();
	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("must have filename, number of nodes, " +
								"number of edges, and density");
			System.exit(0);
		}

		String fileName = args[0];
		int numNodes = Integer.parseInt(args[1]);
		double density = Double.parseDouble(args[2]);
		int maxWeight = Integer.parseInt(args[3]);
		if (numNodes*numNodes*density < numNodes) {
			System.out.println("Warning: the density of this graph is not high " +
								"to make it a connected graph, so edges will be added " +
								"and there will only be one graph traversal path");
			density = 1.0 / numNodes;
		}
		/*
			first line is the number of nodes to make
			the rest of the file are all of the edges along with all of the weights
		*/
		try {
			FileWriter writer = new FileWriter(fileName);
				writer.write(numNodes + "\n"); 
			for (String s : output)
				writer.write(s + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file");
			e.printStackTrace();
		}
	
	}

	private static void generateEdges(int numNodes, double density, int maxWeight) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numNodes; i++)
			list.add(i);

		int totalEdges = (int)(numNodes * density);
		int randIndex = (int)(Math.random() * numNodes);
		int i = numNodes - 1;
		int node = 0;
		int node2 = 0;
		int weight = 0;
		//this loop guarantees that the graph is connected
		while (i > 0 ) {
			node = list.get(randIndex);
			list.remove(randIndex);
			randIndex = (int)(Math.random() * i);
			node2 = list.get(randIndex);
			weight = (int)(Math.random() * maxWeight) + 1;
			output.add(node + " " + node2 + " " + weight);
			i--;
			totalEdges--;
		}
		//this loop adds more edges to increase the density of the graph
		ArrayList<String> edges = new ArrayList<String>();
		String check = "";
		while (totalEdges > 0) {
			node = (int)(Math.random() * numNodes);
			node2 = (int)(Math.random() * numNodes);
			check = node + " " + node2;
			if (edges.contains(check) || node == node2)
				continue;
			edges.add(check);
			weight = (int)(Math.random() * maxWeight) + 1;
			output.add(node + " " + node2 + " " + weight);
			totalEdges--;
		}	
	}
}
