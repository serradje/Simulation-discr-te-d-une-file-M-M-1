
All :
	javac *.java
	
run:
	java MM1 5 6 1000 0
	
run_debug:
	java MM1 5 6 1000 1
	
gen_data:
	./script_data.sh
	
gen_graph:
	gnuplot script_graph.p

clean:
	rm *.class graph/*.txt
	
archive :
	tar -f TP1_Simulation_MM1_Serradj_Elhadi.tar.gz -cvz *.java Makefile script_data.sh script_graph.p graph rapport.pdf
