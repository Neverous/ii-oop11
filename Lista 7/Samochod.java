public class Samochod extends Pojazd
{
	protected String marka;
	Samochod() {}
	Samochod(String marka, String model, int predkosc, int waga)
	{
		super(model, predkosc, waga);
		this.marka = marka;
	}

	public String getMarka()
	{
		return this.marka;
	}

	public boolean setMarka(String marka)
	{
		this.marka = marka;
		return true;
	}

	public String getModel()
	{
		return this.getNazwa();
	}

	public boolean setModel(String model)
	{
		return this.setNazwa(model);
	}

	public String toString()
	{
		return "<Samochod marka:" + this.marka + " model:" + this.nazwa + " predkosc: " + this.predkosc + " waga:" + this.waga + " />";
	}
}
