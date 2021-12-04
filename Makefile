compile:	
	javac *.java

simple:	compile
	java Driver Tests simpleTest.txt output.txt

simple2:	compile
	java Driver Tests simpleTest2.txt output2.txt

clean:
	rm -f *.class
