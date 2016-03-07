import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
public class PojazdFieldset extends JPanel
{
	private Pojazd model;
	private JTextField nazwa,
	                   predkosc,
	                   waga;
	abstract private class ChangeListener implements DocumentListener
	{
		protected Pojazd model;
		protected JTextField entry;

		ChangeListener(Pojazd model, JTextField entry)
		{
			this.model = model;
			this.entry = entry;
		}

		public void changedUpdate(DocumentEvent e) {}
		public void insertUpdate(DocumentEvent e) {this.update();}
		public void removeUpdate(DocumentEvent e) {this.update();}
		abstract public void update();
	}

	private class NazwaChangeListener extends ChangeListener
	{
		NazwaChangeListener(Pojazd model, JTextField entry){super(model, entry);}
		public void update() {this.model.setNazwa(this.entry.getText());}
	}

	private class PredkoscChangeListener extends ChangeListener
	{
		PredkoscChangeListener(Pojazd model, JTextField entry){super(model, entry);}
		public void update() {try{this.model.setPredkosc(Integer.parseInt("0" + this.entry.getText()));}catch(NumberFormatException e){}}
	}

	private class WagaChangeListener extends ChangeListener
	{
		WagaChangeListener(Pojazd model, JTextField entry){super(model, entry);}
		public void update() {try{this.model.setWaga(Integer.parseInt("0" + this.entry.getText()));}catch(NumberFormatException e){}}
	}

	PojazdFieldset(Pojazd model)
	{
		this.model = model;
		this.setLayout(new GridLayout(0, 2));
		this.add(new JLabel("Nazwa:"));
		this.nazwa = new JTextField(this.model.getNazwa());
		this.nazwa.getDocument().addDocumentListener(new NazwaChangeListener(this.model, this.nazwa));
		this.add(this.nazwa);
		this.add(new JLabel("Prędkość:"));
		this.predkosc = new JTextField("" + this.model.getPredkosc());
		this.predkosc.getDocument().addDocumentListener(new PredkoscChangeListener(this.model, this.predkosc));
		this.add(this.predkosc);
		this.add(new JLabel("Waga:"));
		this.waga = new JTextField("" + this.model.getWaga());
		this.waga.getDocument().addDocumentListener(new WagaChangeListener(this.model, this.waga));
		this.add(this.waga);
	}
}
