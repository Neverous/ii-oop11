/* 2012
 * Maciej Szeptuch
 * II UWr
 */
using System;

public class IntStream
{
	protected int state = 0;
	protected const int MAX_NUMBER = int.MaxValue;

	public virtual int next()
	{
		if(state >= MAX_NUMBER)
			return -1;

		return state ++;
	}

	public virtual bool eos()
	{
		return state >= MAX_NUMBER;
	}

	public virtual void reset()
	{
		state = 0;
		return;
	}
}

public class PrimeStream: IntStream
{
	private bool isPrime(int number)
	{
		if(number < 2)
			return false;

		for(int p = 2; p * p <= number; ++ p)
			if(number % p == 0)
				return false;

		return true;
	}

	public override int next()
	{
		++ state;
		while(state < MAX_NUMBER && !isPrime(state))
			++ state;

		if(state >= MAX_NUMBER)
			return -1;

		return state;
	}
}

public class RandomStream: IntStream
{
	protected Random seed = new Random();
	public override int next()
	{
		return seed.Next();
	}
}

public class RandomWordStream
{
	protected RandomStream rand = new RandomStream();
	protected PrimeStream length = new PrimeStream();

	public virtual string next()
	{
		string result = "";
		int len = length.next();
		for(int l = 0; l < len; ++ l)
			result += (char)('a' + rand.next() % 26);

		return result;
	}

	public virtual bool eos()
	{
		return length.eos();
	}

	public virtual void reset()
	{
		length.reset();
	}
}

/* Przykład */
public class Example
{
	public static void Main()
	{
		IntStream integers = new IntStream();
		PrimeStream primes = new PrimeStream();
		RandomStream rand = new RandomStream();
		RandomWordStream words = new RandomWordStream();

		Console.Write("IntegerStream: ");
		for(int i = 0; i < 7 && !integers.eos(); ++ i)
			Console.Write(integers.next() + " ");

		integers.reset();
		for(int i = 0; i < 5 && !integers.eos(); ++ i)
			Console.Write(integers.next() + " ");

		Console.WriteLine();
		Console.Write("PrimeStream: ");
		for(int i = 0; i < 7 && !primes.eos(); ++ i)
			Console.Write(primes.next() + " ");

		primes.reset();
		for(int i = 0; i < 5 && !primes.eos(); ++ i)
			Console.Write(primes.next() + " ");

		Console.WriteLine();
		Console.Write("RandomStream: ");
		for(int i = 0; i < 7 && !rand.eos(); ++ i)
			Console.Write(rand.next() + " ");

		Console.WriteLine();
		Console.Write("RandomWordStream: ");
		for(int i = 0; i < 7 && !words.eos(); ++ i)
			Console.Write(words.next() + " ");

		Console.WriteLine();
		return;
	}
}
