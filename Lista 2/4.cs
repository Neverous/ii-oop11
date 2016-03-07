/* 2012
 * Maciej Szeptuch
 * II UWr
 */
using System;

public class Element
{
	public Element next;
	public int val;

	public Element(int set)
	{
		val = set;
	}
}

public class ListaLeniwa
{
	protected Element root;
	protected Random rand = new Random();

	protected virtual int initialize()
	{
		return rand.Next();
	}

	public int element(int pos)
	{
		if(root == null)
			root = new Element(initialize());

		Element act = root;
		while(-- pos >= 0)
		{
			if(act.next == null)
				act.next = new Element(initialize());

			act = act.next;
		}

		return act.val;
	}
}

public class Pierwsze: ListaLeniwa
{
	private bool isPseudoPrime(int val)
	{
		Element act = root;
		while(act != null && act.val * act.val <= val)
		{
			if(val % act.val == 0)
				return false;

			act = act.next;
		}

		return true;
	}

	protected override int initialize()
	{
		if(root == null)
			return 2;

		Element act = root;
		while(act.next != null)
			act = act.next;

		int prime = act.val;
		while(!isPseudoPrime(prime))
			++ prime;

		return prime;
	}
}

/* Przykład */
public class Example
{
	public static void Main()
	{
		ListaLeniwa rand = new ListaLeniwa();
		Pierwsze primes = new Pierwsze();

		Console.WriteLine(rand.element(1000));
		Console.WriteLine(rand.element(50));

		Console.WriteLine(primes.element(1000));
		Console.WriteLine(primes.element(50));
		for(int i = 0; i < 10; ++ i)
			Console.WriteLine(primes.element(i));
	}
}
