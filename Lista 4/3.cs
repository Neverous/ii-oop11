using System;
class Godzina
{
	private int godzina,
	            minuta,
	            sekunda;

	public int Sekundy
	{
		get
		{
			return this.sekunda + (this.minuta + this.godzina * 60) * 60;
		}
	}

	public Godzina(int godzina = 0, int minuta = 0, int sekunda = 0)
	{
		this.godzina = godzina;
		this.minuta = minuta;
		this.sekunda = sekunda;
		this.normalize();
	}

	private void normalize()
	{
		this.minuta += this.sekunda / 60;
		this.godzina += this.minuta / 60;
		this.sekunda %= 60;
		this.minuta %= 60;
		this.godzina %= 24;
	}

	public void dodaj(int s)
	{
		this.sekunda += s;
		this.normalize();
	}

	public void dodaj(Godzina g)
	{
		this.sekunda += g.sekunda;
		this.minuta += g.minuta;
		this.godzina += g.godzina;
		this.normalize();
	}

	public static int operator-(Godzina a, Godzina b)
	{
		return a.Sekundy - b.Sekundy;
	}

	public override string ToString()
	{
		return String.Format("{0}:{1}:{2}", this.godzina, this.minuta, this.sekunda);
	}
}

class Data
{
	private int dzien,
	            miesiac,
	            rok;
	private static int[] mcdni = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int Dni
	{
		get
		{
			int przestepne = (this.rok - 1) / 4 - (this.rok - 1) / 100 + (this.rok - 1) / 400;
			return this.Dzien + przestepne * 366 + (this.rok - przestepne) * 365;
		}
	}

	public int Dzien
	{
		get
		{
			int result = this.dzien;
			for(int m = 0; m < this.miesiac; ++ m)
				result += Data.mcdni[m];

			if(this.Przestepny && this.miesiac > 2)
				++ result;

			return result;
		}
	}

	public bool Przestepny // via Wikipedia
	{
		get
		{
			if(this.rok % 4 != 0)
				return false;

			if(this.rok % 100 != 0)
				return true;

			if(this.rok % 400 != 0)
				return false;

			return true;
		}
	}

	public Data(int dzien, int miesiac, int rok)
	{
		this.dzien = dzien;
		this.miesiac = miesiac;
		this.rok = rok;
		this.normalize();
	}

	private void normalize()
	{
		if(this.miesiac > 12)
		{
			this.rok += (this.miesiac - 1) / 12;
			this.miesiac = (this.miesiac - 1) % 12 + 1;
		}

		while(this.dzien > Data.mcdni[this.miesiac - 1])
		{
			this.dzien -= Data.mcdni[this.miesiac - 1];
			if(this.miesiac == 2 && this.Przestepny)
				-- this.dzien;

			++ this.miesiac;
			if(this.miesiac > 12)
			{
				this.miesiac = 1;
				++ this.rok;
			}
		}
	}

	public void dodaj(int d)
	{
		this.dzien += d;
		this.normalize();
	}

	public static int operator-(Data a, Data b)
	{
		return a.Dni - b.Dni;
	}

	public override string ToString()
	{
		return String.Format("{0}.{1}.{2}", this.dzien, this.miesiac, this.rok);
	}
}

class Example
{
	public static void Main()
	{
		Godzina a = new Godzina(21, 30, 15),
		        b = new Godzina(5, 45, 27);

		Console.WriteLine("a = {0}({2}), b = {1}({3})", a.Sekundy, b.Sekundy, a, b);
		b.dodaj(58);
		Console.WriteLine("b = {0}({1})", b.Sekundy, b);
		b.dodaj(a);
		Console.WriteLine("b = {0}({1})", b.Sekundy, b);

		Console.WriteLine("a = {0}({3}), b = {1}({4}), a - b = {2}", a.Sekundy, b.Sekundy, a - b, a, b);

		Data c = new Data(27, 03, 2012),
		     d = new Data(06, 07, 4545);

		Console.WriteLine("c = {0}({1}, {2}), d = {3}({4}, {5})", c, c.Dzien, c.Dni, d, d.Dzien, d.Dni);
		d.dodaj(137);
		Console.WriteLine("d = {0}({1}, {2})", d, d.Dzien, d.Dni);
		Console.WriteLine("c - d = {0}", c - d);
	}
}
