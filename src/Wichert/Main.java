package wichert;

import java.io.IOException;
import java.io.RandomAccessFile;

//import java.io.IOException;
//import java.io.RandomAccessFile;

/**
 * Die Klasse Main f�hrt die Methode execute aus nachdem sie nachgesehen hat
 * welche der Befehlsfelder ausgef�llt sich und welche nicht und diese in die
 * zugeh�rigen Variablen speichert.
 * 
 * @author Patrick.W
 * @version 10.01.2015
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out
					.println("-h ... Hostname\n-u ... Benutzername\n-p ... Passwort\n-d ... Datenbank\n-s ... Feld, nach dem sortiert werden soll\n-r ... Sortierrichtung. Standard: ASC\n-w ... eine Bedingung in SQL-Syntax, die zum Filtern der Tabelle verwendet wird\n-t ... Trennzeichen, dass f�r die Ausgabe verwendet werden soll\n-f ... Kommagetrennte Liste der Felder, die im Ergebnis enthalten sein sollen\n-o ... Name der Ausgabedatei sonst: Ausgabe auf der Konsole\n-T ... Tabellenname");
			System.exit(1);
		}

		String output = "";
		String host = "localhost", uname = System.getProperty("user.name"), pwd = "", dbname = "";
		for (int i = 0; i < args.length; i++) 
		{
			if (args[i].equals("-h")) 
			{
				host = args[i + 1];
			}
			if (args[i].equals("-u")) 
			{
				uname = args[i + 1];
			}
			if (args[i].equals("-p")) 
			{
				pwd = args[i + 1];
			}
			if (args[i].equals("-d")) 
			{
				dbname = args[i + 1];
			}
		}
		if (output.equals("")) {
			System.out.println(Rueckwaertssalto.execute(host, uname, pwd, dbname));
		} 
		else 
		{
			try 
			{
				RandomAccessFile file = new RandomAccessFile(output, "rw");
				file.writeUTF(Rueckwaertssalto
						.execute(host, uname, pwd, dbname));
				file.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}