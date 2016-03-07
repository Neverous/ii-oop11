import java.util.HashMap;
import programy.*;
import arytmetyka.*;

public class Zadanie4
{
	public static void main(String args[]) throws ArithmeticException
	{
		HashMap<String, Integer> zmienne = new HashMap<String, Integer>();
		Instrukcja program = new InstrukcjaZlozona(
			new Przypisz("x", new Stala(5)), new InstrukcjaZlozona( // x = 5
			new Przypisz("y", new Stala(1)), new InstrukcjaZlozona( // y = 1
			new Petla(new Zmienna("x"), new InstrukcjaZlozona( // while x:
				new Przypisz("y", new Pomnoz(new Zmienna("y"), new Zmienna("x"))), // y = y * x
				new Przypisz("x", new Odejmij(new Zmienna("x"), new Stala(1))))), // x = x - 1

			new Wypisz(new Zmienna("y"))))); // print y

		program.wykonaj(zmienne);
	}
}
