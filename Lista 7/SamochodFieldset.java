import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
public class SamochodFieldset extends JPanel
{
	private Samochod model;
	private JTextField marka,
	                   smodel,
	                   predkosc,
	                   waga;

	abstract private class ChangeListener implements DocumentListener
	{
		protected Samochod model;
		protected JTextField entry;

		ChangeListener(Samochod model, JTextField entry)
		{
			this.model = model;
			this.entry = entry;
		}

		public void changedUpdate(DocumentEvent e) {}
		public void insertUpdate(DocumentEvent e) {this.update();}
		public void removeUpdate(DocumentEvent e) {this.update();}
		abstract public void update();
	}

	private class MarkaChangeListener extends ChangeListener
	{
		MarkaChangeListener(Samochod model, JTextField entry){super(model, entry);}
		public void update() {this.model.setMarka(this.entry.getText());}
	}

	private class ModelChangeListener extends ChangeListener
	{
		ModelChangeListener(Samochod model, JTextField entry){super(model, entry);}
		public void update() {this.model.setModel(this.entry.getText());}
	}

	private class PredkoscChangeListener extends ChangeListener
	{
		PredkoscChangeListener(Samochod model, JTextField entry){super(model, entry);}
		public void update() {try{this.model.setPredkosc(Integer.parseInt("0" + this.entry.getText()));}catch(NumberFormatException e){}}
	}

	private class WagaChangeListener extends ChangeListener
	{
		WagaChangeListener(Samochod model, JTextField entry){super(model, entry);}
		public void update() {try{this.model.setWaga(Integer.parseInt("0" + this.entry.getText()));}catch(NumberFormatException e){}}
	}

	SamochodFieldset(Samochod model)
	{
		this.model = model;
		this.setLayout(new GridLayout(0, 2));
		this.add(new JLabel("Marka:"));
		this.marka = new JTextField(this.model.getMarka());
		this.marka.getDocument().addDocumentListener(new MarkaChangeListener(this.model, this.marka));
		this.add(this.marka);
		this.add(new JLabel("Model:"));
		this.smodel = new JTextField(this.model.getModel());
		this.smodel.getDocument().addDocumentListener(new ModelChangeListener(this.model, this.smodel));
		this.add(this.smodel);
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
