package programy;
import programy.Instrukcja;
import arytmetyka.Wyrazenie;
import java.lang.ArithmeticException;
import java.util.HashMap;

public class Petla extends Instrukcja
{
	Wyrazenie value;
	Instrukcja doit;
	public Petla(Wyrazenie val, Instrukcja doit)
	{
		this.value = val;
		this.doit = doit;
	}

	public int wykonaj(HashMap<String, Integer> zmienne) throws ArithmeticException
	{
		this.value.oblicz(zmienne);
		while(this.value.oblicz(zmienne) != 0)
			this.doit.wykonaj(zmienne);

		return 0;
	}
}
