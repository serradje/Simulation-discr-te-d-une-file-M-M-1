import java.util.*;

public class MM1
{
	public static double lamda;
	public static double mu;
	public static double duree;
	public static int debug;
	public static Evt e;
	
	
	public static void main (String args[])
	{
		double debut=System.currentTimeMillis();
		if(args.length != 4 )
		{
			System.out.println(" usage:  java MM1 lamda mu duree debug");
		}
		else
		{
		 System.out.println("########## Traitement en cours... #########");
		 lamda = Double.parseDouble(args[0]);
		 mu = Double.parseDouble(args[1]);
		 duree = Double.parseDouble(args[2]);
		 debug = Integer.parseInt(args[3]);
		
		 
		 new Stats();
		 new Ech();
		 e = new Evt(0,false);
		 Ech.fileMM1();
		
		Stats.Resultat_theorique(e);
		Stats.Resultat_simulation();
		System.out.println();
		System.out.print("Fin de la Simulation: ");
		System.out.println("Temps d_éxecution : "+(System.currentTimeMillis()-debut)/1000+" Sec ########");// temps en sec

        }    
}
}
