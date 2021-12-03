compile:	
	javac *.java

simple:	compile
	java Driver Tests simpleTest.txt output.txt

clean:
	rm -f *.class
