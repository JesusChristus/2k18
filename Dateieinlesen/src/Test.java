
import java.io.File;

public class Test
{
	public static void main(String[] args)
	{
		File f = new File("H:\\Eigene Dateien\\java\\2018\\Dateien zum einlesen\\Musiker.txt"/*Pfad als String*/);
		DateiHandler dh = new DateiHandler(f);
		Musiker m = dh.lesen();
		System.out.println(m.toString());
		dh.schliesen();
	}
}
