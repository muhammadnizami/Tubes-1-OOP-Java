
	#sementara tidak pakai object file

bin/Calculator: bin src/main.cpp src/Evaluator.cpp src/history.cpp src/token/converter.cpp src/token/Token.cpp src/token/Arab.cpp src/token/Logika.cpp src/token/Romawi.cpp src/token/mesintoken.cpp src/katakr/mesinkata.cpp src/katakr/mesinkar.cpp src/token/Operator.cpp src/Evaluator.h src/history.h src/token/converter.h src/token/Token.h src/token/Arab.h src/token/Logika.h src/token/Romawi.h src/token/mesintoken.h src/katakr/mesinkata.h src/katakr/mesinkar.h src/token/Operator.h src/stack/stack.h src/FileManager.h src/FileManager.cpp
	g++ src/main.cpp src/Evaluator.cpp src/history.cpp src/token/converter.cpp src/token/Token.cpp src/token/Arab.cpp src/token/Logika.cpp src/token/Romawi.cpp src/token/mesintoken.cpp src/katakr/mesinkata.cpp src/katakr/mesinkar.cpp src/token/Operator.cpp src/FileManager.cpp -o bin/Calculator

bin:
	mkdir bin
