import java.util.*;

//classe de l’échéancier pour stocker les objets Evt dans une liste chaînée.
public class Ech
{
	public static LinkedList<Evt> file;
	public static double dateDepart;
	public static double Tm;
	

	public static void AddList(LinkedList<Evt> file, Evt e)
	{// ajout par ordre d'arrivée
		double newDate= e.date;
		int i=0;
		while(i<file.size() && file.get(i).date<newDate)// on parcour la file
		{
			i++;
		}
		file.add(i,e); //on ajoute l'evt au ienme position
	}
	
	public static LinkedList<Evt> traitement(LinkedList<Evt> file,Evt e, Stats state)
	{
		double stemps = e.date;
		double timeArrivee;
		double timeDepart;
		double TMoyen;
		Evt arrivee,depart;
		int client=e.num_client;
		if(e.type_evt == true)
		{
			Utile.traitementEvenArrivee(e);// on traite les stats de l'evt arrivee
			if(stemps <= MM1.duree)
			{
				timeArrivee = stemps+(Utile.duree_loi_exp(MM1.lamda));
				if(timeArrivee <= MM1.duree)
				{
					arrivee = new Evt(timeArrivee,true);
					arrivee.num_client = client+1;
					AddList(file,arrivee);
				}
			}
			timeDepart = dateDepart+Utile.duree_loi_exp(MM1.mu);
			while((timeDepart < stemps))
			{
				timeDepart = dateDepart+Utile.duree_loi_exp(MM1.mu);
			}
			depart = new Evt(timeDepart,false);
			dateDepart=depart.date;// lui donner sa date de depart
			depart.num_client=client; // lui donner son numero
			AddList(file,depart); // on l'ajoute dans la file
			TMoyen = dateDepart - stemps;
			Tm = Tm + TMoyen; // temps moyen dans le sys
		}
		else
		{
			Utile.traitementEvenDepart(e); // on triate les stats de l'evt depart
		}
		return file;
	}
	
	public static void fileMM1() 
	{
		double timeArrivee;// date d'arrivee de l'evt
		//initialisation
		Stats fileState = new Stats();
		Evt e = new Evt();
		Evt arrivee;
		Evt depart;
		file = new LinkedList<Evt>();
		AddList(file,e);// ajout de e dans la file
		Utile.traitementEvenArrivee(e);
		
		if(MM1.debug == 1) //affichage si debug = 1 sinon on affiche rien
		{
			System.out.println("Date : "+e.date+" Arrivee client #"+e.num_client);
		}
		e = file.removeFirst(); //on supprime l'Evnt arrivée de l'echancier si elle est en premier
		timeArrivee = e.date+Utile.duree_loi_exp(MM1.lamda);
		if(timeArrivee <= MM1.duree)// date arrivée doit etre inferieur à la durée donner en paramettre
		{
			arrivee = new Evt(timeArrivee,true);
			arrivee.num_client = e.num_client+1;
			AddList(file,arrivee);
		}
		depart = new Evt(e.date+Utile.duree_loi_exp(MM1.mu),false);
		depart.num_client = e.num_client;
		AddList(file,depart);
		dateDepart = depart.date;
		
		while(!file.isEmpty()) // tant que la file n'est pas vide
		{
			e = file.removeFirst();
			file = traitement(file,e,fileState);
			if(MM1.debug == 1) //affichage si debug = 1 sinon on affiche rien
			{
				if(e.type_evt == true) // si true on affiche les evenements
				{
					System.out.println("Date : "+e.date+" Arrivee client #"+e.num_client);
				}
				else // sinon on affiche les depart
				{
					System.out.println("Date : "+e.date+" Depart client #"+e.num_client+" Arrive à t= "+Stats.getTempsArrivee(e.num_client));
				}
			}
		}
	}
							

	
}
