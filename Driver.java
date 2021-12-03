//Driver.java

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Driver {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("must have input directory, input file, and output file");
			System.exit(0);
		}
		
		ArrayList<String> files = new ArrayList<String>();
		String dir = args[0];
		String input = args[1];
		String outputFile = args[2];
		try {
			File inputFile = new File(input);
			Scanner scanner = new Scanner(inputFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				files.add(dir + "/" + line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error reading input files");
			e.printStackTrace();
		}

		for (String file : files) {
			try {
				File inputFile = new File(file);
				Scanner scanner = new Scanner(inputFile);
				PrintWriter o = new PrintWriter(new BufferedWriter(new FileWriter(new File(outputFile))));
				int numNodes = Integer.parseInt(scanner.nextLine());
			//	Graph radix = new Radix(numNodes);
			//	Graph fibonacci = new Fibonacci(numNodes);
				Graph simple = new SimpleGraph(numNodes);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] arr = line.split(" ");
					Node src = new Node(arr[0]);
					Node dest = new Node(arr[1]);
					int weight = Integer.parseInt(arr[2]);
					//radix.addEdge(src, dest, weight);
					//fibonacci.addEdge(src, dest, weight);
					simple.addEdge(src, dest, weight);
				}
				//radix.generateMinSpanningTree();
				//fibonacci.generateMinSpanningTree();
				simple.generateMinSpanningTree();
				System.out.println("Success");
				for(Edge e : simple.getMST()) {
					o.println("(" + e.getSrc().getName() + "," + e.getDest().getName() + ")");
				}
				o.close();
			} catch (Exception e) {
				System.out.println("Error reading graph files");
				e.printStackTrace();
			}
		}

	}
}
