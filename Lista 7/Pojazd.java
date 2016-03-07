import java.io.*;
class Pojazd implements Serializable
{
	protected String nazwa;
	protected int predkosc,
	              waga;

	Pojazd() {}
	Pojazd(String nazwa, int predkosc, int waga)
	{
		this.setNazwa(nazwa);
		this.setPredkosc(predkosc);
		this.setWaga(waga);
	}

	public String getNazwa()
	{
		return this.nazwa;
	}

	public boolean setNazwa(String nazwa)
	{
		this.nazwa = nazwa;
		return true;
	}

	public int getPredkosc()
	{
		return this.predkosc;
	}

	public boolean setPredkosc(int predkosc)
	{
		this.predkosc = predkosc;
		return true;
	}

	public int getWaga()
	{
		return this.waga;
	}

	public boolean setWaga(int waga)
	{
		this.waga = waga;
		return true;
	}

	public String toString()
	{
		return "<Pojazd nazwa:" + this.nazwa + " predkosc:" + this.predkosc + " waga:" + this.waga + " />";
	}
}
