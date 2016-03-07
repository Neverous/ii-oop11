import java.util.HashMap;
import java.lang.ArithmeticException;
import arytmetyka.*;

public class Zadanie3
{
	public static void main(String args[]) throws ArithmeticException
	{
		HashMap<String, Integer> zmienne = new HashMap<String, Integer>();
		zmienne.put("x", 175);
		zmienne.put("y", 13);
		Wyrazenie temp = new Dodaj(new Stala(4), new Zmienna("x"));
		System.out.println(temp.oblicz(zmienne));
		temp = new Pomnoz(temp, temp);
		System.out.println(temp.oblicz(zmienne));
		temp = new Odejmij(temp, new Zmienna("y"));
		System.out.println(temp.oblicz(zmienne));
		temp = new Podziel(temp, new Stala(10));
		System.out.println(temp.oblicz(zmienne));
	}
}
