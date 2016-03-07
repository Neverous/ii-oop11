package programy;
import java.lang.ArithmeticException;
import java.util.HashMap;
import programy.Instrukcja;

public class InstrukcjaZlozona extends Instrukcja
{
	Instrukcja first,
	           second;

	public InstrukcjaZlozona(Instrukcja a, Instrukcja b)
	{
		this.first = a;
		this.second = b;
	}

	public int wykonaj(HashMap<String, Integer> zmienne) throws ArithmeticException
	{
		this.first.wykonaj(zmienne);
		this.second.wykonaj(zmienne);
		return 0;
	}
}
