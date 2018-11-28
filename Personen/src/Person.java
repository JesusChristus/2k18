
public class Person
{
	private String name;
	private String gebDat;
	private double gehalt;
	private static int anzahl = 0;
	private int personalNr;
	
	

	public Person()
	{
		
	}
	
	public Person(String name, String gebDat, double gehalt)
	{
		this.gehalt = gehalt;
		this.name = name;
		this.gebDat = gebDat;
		this.personalNr = anzahl;
		anzahl++;
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

	public String getGebDat()
	{
		return gebDat;
	}

	public void setGebDat(String gebDat)
	{
		this.gebDat = gebDat;
	}

	public int getPersonalNr()
	{
		return personalNr;
	}	
	
	public void setPersonalNr(int personalNr)
	{
		this.personalNr = personalNr;
	}
	
	public double getGehalt()
	{
		return gehalt;
	}

	public void setGehalt(double gehalt)
	{
		this.gehalt = gehalt;
	}
	
	
	
}
