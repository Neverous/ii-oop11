import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Editor implements ActionListener
{
	public static void main(String[] argv)
	{
		if(argv.length < 2)
		{
			System.out.println("Podaj plik i nazwę klasy!");
			System.exit(121);
		}

		(new Editor(argv)).run();
	}

	private String title,
	               filename;
	private Pojazd model;
	private JFrame window;

	Editor(String[] argv)
	{
		this.filename = argv[0];
		this.load();
		this.window = new JFrame("Edytor");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setLayout(new GridLayout(0, 1, 20, 20));
		switch(argv[1])
		{
			case "Pojazd":
				this.title = "Edytor pojazdu";
				if(this.model == null)
					this.model = new Pojazd();

				this.window.add(new PojazdFieldset(this.model));
				break;

			case "Samochod":
				this.title = "Edytor samochodu";
				if(this.model == null)
					this.model = new Samochod();

				this.window.add(new SamochodFieldset((Samochod) this.model));
				break;

			case "Tramwaj":
				this.title = "Edytor tramwaju";
				if(this.model == null)
					this.model = new Tramwaj();

				this.window.add(new TramwajFieldset((Tramwaj) this.model));
				break;

			default:
				System.out.println("Nieprawidłowa nazwa klasy. Wybierz jedną z Pojazd, Samochod, Tramwaj!");
				System.exit(131);
				break;
		}

		this.window.setTitle(this.title);
	}

	public void run()
	{
		JButton button = new JButton("Zapisz");
		button.addActionListener(this);
		this.window.add(button);
		button = new JButton("Anuluj");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		this.window.add(button);
		this.window.pack();
		this.window.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		this.save();
	}

	public boolean save()
	{
		FileOutputStream file = null;
		ObjectOutputStream out = null;
		try
		{
			file = new FileOutputStream(this.filename);
			out = new ObjectOutputStream(file);
			out.writeObject(this.model);
			return true;
		}
		catch(FileNotFoundException e) {e.printStackTrace();} 
		catch(IOException e) {e.printStackTrace();} 
		finally
		{
			try {if(out != null) out.close();}
			catch(IOException e) {}

			try {if(file != null) file.close();}
			catch(IOException e) {}
		}

		return false;
	}

	public Pojazd load()
	{
		FileInputStream file = null;
		ObjectInputStream in = null;
		try
		{
			file = new FileInputStream(this.filename);
			in = new ObjectInputStream(file);
			this.model = (Pojazd) in.readObject();
			return this.model;
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		finally 
		{
			try {if (in != null) in.close();}
			catch (IOException e) {}

			try {if (file != null) file.close();}
			catch (IOException e) {}
		}

		this.model = null;
		return this.model;
	}
}
