
public class Musiker
{
	private int alter;
	private String name;
	private String instrument;
		
	public Musiker(int alter, String name, String instrument)
	{
		super();
		this.alter = alter;
		this.name = name;
		this.instrument = instrument;
	}

	public int getAlter()
	{
		return alter;
	}

	public void setAlter(int alter)
	{
		this.alter = alter;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getInstrument()
	{
		return instrument;
	}

	public void setInstrument(String instrument)
	{
		this.instrument = instrument;
	}

	@Override
	public String toString()
	{
		return "Musiker [alter=" + alter + ", \nname=" + name + ", \ninstrument=" + instrument + "]";
	}
}
