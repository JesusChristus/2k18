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
	
	public Musiker lesen()
	{
		if(s.hasNext())
		{
			int alter = s.nextInt();
			String name = s.next(";");
			String instrument  = s.next();
			return new Musiker(alter, name, instrument);
		}
		else
		{
			return null;
		}
	}
	
	public void schliesen()
	{
		s.close();
	}
}
