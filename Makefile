compile:	
	javac *.java

simple:	compile
	java Driver Tests simpleTest.txt output.txt

simple2:	compile
	java Driver Tests simpleTest2.txt output2.txt

simple3:	compile
	java Driver Tests simpleTest3.txt output3.txt

alltest:	compile
	java Driver Tests allTest.txt allOut.txt

clean:
	rm -f *.class
