using System;
class Example
{
	public static void Main()
	{
		Lista<int> lista = new Lista<int>();
		Console.WriteLine("Lista empty? {0}", lista.empty());
		lista.push_back(20);
		lista.push_back(15);
		lista.push_back(234234);
		Console.WriteLine("Lista empty? {0}", lista.empty());
		Console.WriteLine("Lista pop_back? {0}", lista.pop_back());
		Console.WriteLine("Lista pop_front? {0}", lista.pop_front());
		Console.WriteLine("Lista pop_front? {0}", lista.pop_front());
		Console.WriteLine("Lista empty? {0}", lista.empty());

		AlmostSingleton A = AlmostSingleton.Instance(),
		                B = AlmostSingleton.Instance(),
		                C = AlmostSingleton.Instance(),
		                D = AlmostSingleton.Instance(),
		                E = AlmostSingleton.Instance();

		A.nazwa = "A"; B.nazwa = "B"; C.nazwa = "C"; D.nazwa = "D"; E.nazwa = "E";
		Console.WriteLine("{0}, {1}, {2}, {3}, {4}", A.nazwa, B.nazwa, C.nazwa,
		                  D.nazwa, E.nazwa);
		for(int i = 0; i < 7; ++ i)
			Console.WriteLine(AlmostSingleton.Instance().nazwa);
	}
}
