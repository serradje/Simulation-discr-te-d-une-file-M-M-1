#!/bin/sh

#on supprime le fichier si il existe
#rm -f "grap/data.txt"

#=============================
# CONTENU DE FICHIER GÉNÉRÉ :
#=============================
# $1 - duree de simulation
# $2 - lambda
# $3 - mu
# $4 - durée d'éxécution
	
	#=======================
	# RESULTATS THEORIQUES
	#=======================
	# $5 - ro (= prob file occupée)
	# $6 - nombre de clients attendus
	# $7 - proba service sans attente
	# $8 - espérance nombre de clients
	# $9 - temps moyen de séjour

	#=======================
	# RÉSULTATS SIMULATION
	#=======================
	# $10 - nombre total de clients
	# $11 - proportion clients sans attente
	# $12 - proportion clients avec attente
	# $13 - débit
	# $14 - nb moyen de clients dans systeme
	# $15 - temps moyen de sejour

	

# fonction qui recupère les données nécessaires:
Function() {
	lambda=$1
	mu=$2
	duree=$3
	
  SIMULATION=$(java MM1 "$lambda" "$mu" "$duree" 0  2>&1)
  TEMPS_EXECUTION=$(echo "$SIMULATION" | awk '/Fin de la Simulation/ {print $8}')

  #on recupère les données de résultats théoriques
  RO=$(echo "$SIMULATION" | awk '/Prob file occupee/{print $NF;}')
  NBCA=$(echo "$SIMULATION" | awk '/nombre de clients attendus/{print $NF;}')
  PROPSSA=$(echo "$SIMULATION" | awk '/Prob de service sans attente/{print $NF;}')
  ESPNBC=$(echo "$SIMULATION" | awk '/Esp nb clients/{print $NF;}')
  TMST=$(echo "$SIMULATION" | awk '/Temps Moyen de sejour/{print $NF;}')

  #on recupère les données de résultats de la simulation
  NBTC=$(echo "$SIMULATION" | awk '/Nombre total de clients =/{print $NF;}')
  PROPCSA=$(echo "$SIMULATION" | awk '/Proportion clients sans attente =/{print $NF;}')
  PROPCAA=$(echo "$SIMULATION" | awk '/Proportion clients avec attente =/{print $NF;}')
  DEBIT=$(echo "$SIMULATION" | awk '/Débit =/{print $NF;}')
  NBMCS=$(echo "$SIMULATION" | awk '/Nb moyen de clients dans systeme =/{print $NF;}')
  TMSS=$(echo "$SIMULATION" | awk '/Temps moyen de sejour =/{print $NF;}')

  echo "$duree $lambda $mu $TEMPS_EXECUTION $RO $NBCA $PROPSSA $ESPNBC $TMST $NBTC $PROPCSA $PROPCAA $DEBIT $NBMCS $TMSS " >> "graph/data.txt"
  
}

# on simule notre file MM1 en faisant varier la durée ( de 10 à 10 Millions) * 100
for t in 10 100 1000 10000 100000 1000000 10000000; do
        for i in `seq 100`; do #on repete 100 la simulation
          Function 5 6 "$t"    
		done
done

#sert pour la generation des graph
sort -n graph/data.txt > graph/data_sort.txt
rm graph/data.txt

exit 0
