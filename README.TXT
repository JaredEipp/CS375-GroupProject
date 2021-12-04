# CS375-GroupProject
Group Project for CS375 with Jared Eipp, Justin Hertik, and Donal George

To run this program, there are some steps involed
I have created a directory called Tests, which holds all of the test files inside.
That directory is is the first command line argument without the '/'.
The second commant line argument an input file that contains all filenames
inside of the first arguments directory.
I do this by using the command 'ls Tests/ > inputFile.txt'. 
The program uses this to loop through each test file and run all of them at one time
instead of running the program multiple times.
Because of this, we only need one output file, whose name is the 3rd command line
argument.
The output file generates the output of all tests for all algorithms in one file,
separated by a single newline for each method.
The structure of the output is as follows:
a single integer number (i)
a single decimal number (ii)
three numbers repeated (i) times. (iii)
a single newline (iv)

(i):
EX: 10
This is the start of a new problem, and it indicates how many nodes are in the graph.
We use this because it allows us to confirm that we have enough edges to make a 
minimum spanning tree.

(ii):
EX: 1.75809
This will be the time taken to solve the problem, in seconds

(iii):
EX: 14 28 7
The first two numbers of these are the src and dest nodes, respectively.
They are numbers, but they are the string name of the node.
The third number represents the weight of the edge between them.

(iv):
The newline is used to separate problems from one another.
The problems will be grouped in groups of 3, where each group has the
same number of nodes. The group will solve the problems in the following
order: radix sort, fibonacci heap, min heap.
