import java.util.LinkedList;

//classe regroupant la collecte et l’affichage des résultats de simulation
public class Stats {
	
	static LinkedList<Double> listeTps;	//liste du temps d'arrivee
	static double NbClient;			//Nb de clients dans le système
	static double NbClientTotal;		//Nb total de clients
	static double NbClSansAttente;		//Nb de client servis sans attente
	static double NbClientMoyen;		//Nb moyen de client dans le systeme
	static double TempsMoyen;		//temps moyen de séjour
	static double TempsSimulation;		//temps de simulation
	

	public Stats()
	{
		listeTps=new LinkedList<Double>();
		this.TempsMoyen=0;		
		this.TempsSimulation=0;	
		this.NbClient=0;	
		this.NbClientTotal=0;	
	    this.NbClSansAttente=0;		
	    this.NbClientMoyen=0;	
	  
	}
	
	public static double getTempsArrivee(int i) 
	{	//on recupère le temps d'arrivée de ienme Evenement
		return listeTps.get(i);
	}
	
	public static void Resultat_theorique(Evt e) 
	{	//  collecte stats theorique
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("   RESULTAT THEORIQUES    ");
		System.out.println("--------------------------");
		
		if(MM1.lamda < MM1.mu)
		{
			System.out.println("lambda < mu : file stable");
		}
		else
		{
			System.out.println("lambda > mu : file instable");
		}
		System.out.println("ro = "+Utile.ro());
		System.out.println("nombre de clients attendus (lambda x duree) = "+MM1.lamda*MM1.duree);
		System.out.println("Prob de service sans attente (1 - ro) =  "+(1- Utile.ro()));
		System.out.println("Prob file occupee (ro) =  "+Utile.ro());
		System.out.println("Debit (lambda) =  "+Utile.debit());
		System.out.println("Esp nb clients (ro/1-ro) =  "+Utile.EspNbClient());
		System.out.println("Temps Moyen de sejour (1/mu(1-ro)) =  "+Utile.TempsMoyenSejour());
	}
	
	public static void Resultat_simulation() 
	{	//collecte stats simulation
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("   RESULTAT SIMULATION    ");
		System.out.println("--------------------------");
		System.out.println("Nombre total de clients = "+NbClientTotal);
		System.out.println("Proportion clients sans attente = "+(NbClSansAttente/NbClientTotal));
		System.out.println("Proportion clients avec attente = "+(1-(NbClSansAttente/NbClientTotal)));
		System.out.println("Débit = "+NbClientTotal/TempsSimulation);
		System.out.println("Nb moyen de clients dans systeme = "+(/*NbClientTotal-*/TempsSimulation)/MM1.duree);
		System.out.println("Temps moyen de sejour = "+TempsMoyen);
		
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
