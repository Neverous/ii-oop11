package arytmetyka;
import java.util.HashMap;
import java.lang.ArithmeticException;
public abstract class Wyrazenie
{
	abstract public int oblicz(HashMap<String, Integer> zmienne) throws ArithmeticException;
}

