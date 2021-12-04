//Driver.java

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

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

		ArrayList<String> output = new ArrayList<String>();
		for (String file : files) {
			try {
				File inputFile = new File(file);
				Scanner scanner = new Scanner(inputFile);
				int numNodes = Integer.parseInt(scanner.nextLine());
				output.add(numNodes + "\n");
				Graph radix = new Radix(numNodes);
				Graph fibonacci = new Fibonacci(numNodes);
				Graph simple = new SimpleGraph(numNodes);
				Graph minHeap = new MinHeap(numNodes);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] arr = line.split(" ");
					Node src = new Node(arr[0]);
					Node dest = new Node(arr[1]);
					int weight = Integer.parseInt(arr[2]);
					//radix.addEdge(src, dest, weight);
					fibonacci.addEdge(src, dest, weight);
					simple.addEdge(src, dest, weight);
					minHeap.addEdge(src, dest, weight);
				}
				long start = System.nanoTime();
				//ArrayList<String> radixTree = radix.generateMinSpanningTree();
				double time = (System.nanoTime() - start) / 1000000.0;
				output.add(time + "\n");
				//output.addAll(radixTree);
				output.add("\n");
				start = System.nanoTime();
				//ArrayList<String> fibonacciTree = fibonacci.generateMinSpanningTree();
				time = (System.nanoTime() - start) / 1000000.0;
				output.add(time + "\n");
				//ouptut.addAll(fibonacciTree);
				output.add("\n");
				//simple.generateMinSpanningTree();
				start = System.nanoTime();
			//	ArrayList<String> minHeapTree = minHeap.generateMinSpanningTree();
				time = (System.nanoTime() - start) / 1000000.0;
				output.add(time + "\n");
				//output.addAll(minHeapTree);
				output.add("\n");
				System.out.println("Success");
			} catch (FileNotFoundException e) {
				System.out.println("Error reading graph files");
				e.printStackTrace();
			}
		}

		try {
			FileWriter writer = new FileWriter(outputFile, true);
			for (String s : output) 
				writer.write(s);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file");
			e.printStackTrace();
		}

	}
}
