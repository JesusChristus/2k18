import java.util.ArrayList;

public class Pizza
{
	private String name;
	private ArrayList<Double> preise = new ArrayList<Double>();
	private double extrakosten;
	private double gesamtkosten;
	private double preisAktuell;

	public Pizza()
	{
		
	}
	
	public Pizza(String name, double preisS, double preisM, double preisL)
	{
		this.name = name;
		preise.add(preisS);
		preise.add(preisM);
		preise.add(preisL);
		extrakosten = 0;
	}
	
	public void addExtra()
	{
		extrakosten += 0.5;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public ArrayList<Double> getPreise()
	{
		return preise;
	}
	
	public double getExtrakosten()
	{
		return extrakosten;
	}
	
	public double getGesamtkosten()
	{
		return gesamtkosten;
	}

	public void setGesamtkosten(double gesamtkosten)
	{
		this.gesamtkosten = gesamtkosten;
	}

	public double getPreisAktuell()
	{
		return preisAktuell;
	}

	public void setPreisAktuell(double preisAktuell)
	{
		this.preisAktuell = preisAktuell;
	}
	
	public void setPreise(ArrayList<Double> preise)
	{
		this.preise = preise;
	}

	public void setExtrakosten(double extrakosten)
	{
		this.extrakosten = extrakosten;
	}
	
}
