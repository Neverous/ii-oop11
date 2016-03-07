package programy;
import programy.Instrukcja;
import arytmetyka.Wyrazenie;
import java.lang.ArithmeticException;
import java.util.HashMap;

public class Wypisz extends Instrukcja
{
	Wyrazenie value;
	public Wypisz(Wyrazenie ex)
	{
		this.value = ex;
	}

	public int wykonaj(HashMap<String, Integer> zmienne) throws ArithmeticException
	{
		System.out.println(this.value.oblicz(zmienne));
		return 0;
	}
}
