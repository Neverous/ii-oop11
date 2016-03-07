package programy;
import java.util.HashMap;
import java.lang.ArithmeticException;
import arytmetyka.Wyrazenie;
import programy.Instrukcja;

public class Przypisz extends Instrukcja
{
	private String key;
	private Wyrazenie value;
	public Przypisz(String key, Wyrazenie value)
	{
		this.key = key;
		this.value = value;
	}

	public int wykonaj(HashMap<String, Integer> zmienne) throws ArithmeticException
	{
		Integer temp = this.value.oblicz(zmienne);
		zmienne.put(this.key, temp);
		return temp;
	}
}
