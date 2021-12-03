//GraphGenerator.java

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;

public class GraphGenerator {
	private static ArrayList<String> output = new ArrayList<String>();
	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("must have filename, number of nodes, " +
								"density, and maximum edge weight");
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
		generateEdges(numNodes, density, maxWeight);
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

		int totalEdges = (int)(numNodes * numNodes * density);
		int randIndex = (int)(Math.random() * numNodes);
		int i = numNodes - 1;
		int node = 0;
		int node2 = 0;
		int weight = 0;
		ArrayList<String> edges = new ArrayList<String>();
		String check = "";
		//this loop guarantees that the graph is connected
		while (i > 0 ) {
			node = list.get(randIndex);
			list.remove(randIndex);
			randIndex = (int)(Math.random() * i);
			node2 = list.get(randIndex);
			weight = (int)(Math.random() * maxWeight) + 1;
			output.add(node + " " + node2 + " " + weight);
			check = node + " " + node2;
			edges.add(check);
			check = node2 + " " + node;
			edges.add(check);
			i--;
			totalEdges--;
		}
		//this loop adds more edges to increase the density of the graph
		check = "";
		String check2 = "";
		int n = 0;
		ArrayList<Integer> ee = new ArrayList<Integer>();
		for (int j = 0; j < numNodes; j++)
			ee.add(0);
		node = (int)(Math.random() * numNodes);
		ee.set(node, 1);
		while (totalEdges > 0) {
			node2 = (int)(Math.random() * numNodes);
			check = node + " " + node2;
			check2 = node2 + " " + node;
			if (edges.contains(check) || edges.contains(check2) || node == node2) {
//				System.out.println("bad guess");
				continue;
			/*
			} else if (check.equals(check2) || ee.get(node) > ((numNodes*density)+1)
						|| ee.get(node2) > ((numNodes*density)+1)) {
				continue;
			} else {
			*/
			} else if (check.equals(check2)) {
				continue;
			} else {
				node = (int)(Math.random() * numNodes);
			}
//			ee.set(node, ee.get(node)+1);
//			ee.set(node2, ee.get(node2)+1);
			edges.add(check);
			weight = (int)(Math.random() * maxWeight) + 1;
			output.add(node + " " + node2 + " " + weight);
			totalEdges--;
			n++;
			System.out.println(n + " edges found");
		}	
	}
}
