package arytmetyka;
import java.util.HashMap;
import java.lang.ArithmeticException;
import arytmetyka.Wyrazenie;

public class Dodaj extends Wyrazenie
{
	private Wyrazenie left,
	                  right;

	public Dodaj(Wyrazenie left, Wyrazenie right)
	{
		this.left = left;
		this.right = right;
	}

	public int oblicz(HashMap<String, Integer> zmienne) throws ArithmeticException
	{
		if(this.left == null || this.right == null)
			throw new ArithmeticException();

		return this.left.oblicz(zmienne) + this.right.oblicz(zmienne);
	}
}

