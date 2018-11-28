import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DateiHandler
{
	Scanner s;
	DateiHandler (File f)
	{
		try
		{
			s = new Scanner(f);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public Person lesen()
	{
		if(s.hasNext())
		{
			//System.out.println(s.nextLine());
			
			String [] data = s.nextLine().split(";");

			double temp =  Double.valueOf(data[2]).doubleValue();
			Person p = new Person(data[0], data[1], temp);
			System.out.println(temp);
			return p;
			
			/*
			Person p = new Person();
			p.setName(s.next());
			p.setGebDat(s.next());
			p.setGehalt(s.nextDouble());
			return p;*/
		}
		else
		{
			return null;
		}
	}

	public void schliessen()
	{
		s.close();
	}
}