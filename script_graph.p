#generation des courbes dans un fichier "graphe_simulation.pdf"

set terminal pdf
set output 'graphe_simulation.pdf'

set grid
set logscale x
set style line 1 lt 1 lw 1 pt 7 pi -1 ps 1.5
set pointintervalbox 3

#genere la courbe "Temps d'éxecution en fonction de la durée de simulation"
set xlabel "Durée de la simulation"
set ylabel "Temps d'éxecution(sec)"
set title "Temps d'éxecution en fonction de la durée de simulation"
plot "graph/data_sort.txt" using 1:4 title "Temps d'éxecution (Sec)" with linespoint linestyle 3

#genere la courbe "Résultat Simulation et Théorique de la Valeur de ro()"
set xlabel "Durée de la simulation"
set ylabel "ro()"
set title "Résultat Simulation et Théorique de la Valeur de ro()"
plot "graph/data_sort.txt" using 1:12 title "Résultat Simulation" with point linestyle 1, "" using 1:5 title "Résultat Theorique" with linespoint lt 3

#genere la courbe "Probabilité de clients sans attente en fonction de la durée de simulation"
set xlabel "Durée de la simulation"
set ylabel "Proportion clients sans attente"
set title "Probabilité de clients sans attente en fonction de la durée de simulation"
plot "graph/data_sort.txt" using 1:11 title "Résultat Simulation" with point linestyle 1, "" using 1:7 title "Résultat Theorique" with linespoint lt 3

#genere la courbe "Temps moyen de séjour en fonction de la durée de simulation"
set xlabel "Durée de la simulation"
set ylabel "Proportion clients sans attente"
set title "Temps moyen de séjour en fonction de la durée de simulation"
plot "graph/data_sort.txt" using 1:15 title "Résultat Simulation" with point linestyle 1, "" using 1:9 title "Résultat Theorique" with linespoint lt 3

#genere la courbe "Nombre de client au cours de temps"
set xlabel "Nombre de Clients"
set ylabel "Temps d'éxecution(sec)"
set title "Temps d'éxecution en fonction de la durée de simulation"
plot "graph/data_sort.txt" using 10:4 title "Temps d'éxecution (Sec)" with linespoint linestyle 3
