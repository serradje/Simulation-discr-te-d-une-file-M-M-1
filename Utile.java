import java.util.*;

//classe regroupant toutes les méthodes statiques utiles (tirage aléatoire, loi exponentielle, ...)
public class Utile {
	
	Evt e;
	public static double v_a_uniforme()
	{
		return Math.random();
	}
	
	public static double duree_loi_exp(double lamda)
	{
		return ((-(Math.log(1-Math.random()))) / lamda);
	}
	
	public static double taux_utilisation()
	{
		return MM1.lamda/MM1.mu;
	}

	public static double prob_service_sans_attente()
	{
		return 1 - taux_utilisation();	
	}
	
	public static double prob_service_avec_attente()
	{
		return 1- prob_service_sans_attente();	
	}
	
	
	public static double debit()
	{
		return MM1.lamda;
	}
	
	public static double nb_moyen_client_dans_system()
	{
		return (taux_utilisation()/(1-taux_utilisation()));
		
	}
	
	public static  double temps_moyen_sejour_dans_system()
	{
		return 1/(MM1.mu*(1-taux_utilisation()));
		
	}
	
	public static double ro()
	{
		return MM1.lamda/MM1.mu;
	}
	public static double EspNbClient()
	{
		return ro()/(1-ro());
	}
	
	public static double TempsMoyenSejour()
	{
		return 1/(MM1.mu * (1-ro()));
	}
	
	 public static double nbMoyenClient()
	 {
		 return Stats.NbClientTotal/Stats.TempsSimulation;
	 }
	 
	 public static double TempsMoyen()
	 {
		 return Ech.Tm/Stats.NbClientTotal;
	 }
	
	public static void traitementEvenArrivee(Evt e)
	{	//traitement l'arrivée d'un evenement
		Stats.NbClientTotal++;
		Stats.listeTps.add(e.date);
		if(e.type_evt == true && Stats.NbClient == 0 || Stats.NbClient == Stats.NbClientTotal/2)
		Stats.NbClSansAttente++;
		Stats. NbClient++;
		Stats.NbClientMoyen=(Stats.NbClientTotal/Stats.TempsSimulation);
	 }
	 
	
	 
	public static void traitementEvenDepart(Evt e)
	{	//traitement le depart d'un evenement
		Stats.TempsSimulation=e.date;
		Stats.NbClient--;
		Stats.NbClientMoyen=(Stats.NbClientTotal/Stats.TempsSimulation);
		Stats.TempsMoyen=Ech.Tm/Stats.NbClientTotal;
	}
		
		
		
		
		
		
		
	
}
	
