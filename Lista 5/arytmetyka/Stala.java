package arytmetyka;
import java.util.HashMap;
import arytmetyka.Wyrazenie;
public class Stala extends Wyrazenie
{
	private int value;
	public Stala(int value)
	{
		this.value = value;
	}

	public int oblicz(HashMap<String, Integer> zmienne)
	{
		return this.value;
	}
}
