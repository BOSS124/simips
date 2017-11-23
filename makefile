all:
	javac ./src/*.java ./src/mips/*.java -d ./bin/
	jar cfm ./simips.jar ./manifest.mf -C ./bin/ .

run:
	make all
	java -jar ./simips.jar