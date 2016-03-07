package arytmetyka;
import java.util.HashMap;
import java.lang.ArithmeticException;
import arytmetyka.Wyrazenie;

public class Zmienna extends Wyrazenie
{
	private String key;
	public Zmienna(String key)
	{
		this.key = key;
	}

	public int oblicz(HashMap<String, Integer> zmienne) throws ArithmeticException
	{
		return zmienne.get(this.key);
	}
}
