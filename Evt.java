import java.util.*;

// classe des événements
public class Evt
{
	
	public double date; 	//date d'arrivée ou de départ selon l'évènement 
	public boolean type_evt; 	// true arrivee, false depart
	public int num_client; 	// numero client correspondant à l'evenement
	
	public Evt()
	{
		type_evt=true;
		date=0;
	}

	public Evt( double date, boolean type_evt)
	{
		this.date=date;
		this.type_evt=type_evt;
	
	}

	public boolean getType()
	{
		return type_evt;
	}
	
	public double getTime()
	{
		return date;
	}
	
	

}
