import java.io.*;
class Element<Type> implements Serializable
{
	public Type value;
	public Element<Type> next,
						 prev;

	Element(Type value, Element<Type> prev, Element<Type> next)
	{
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
	
	Element(Type value, Element<Type> prev)
	{
		this.value = value;
		this.prev = prev;
		this.next = null;
	}

	Element(Type value)
	{
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}

class List<Type> implements Serializable
{
	Element<Type> front,
				  back;

	public boolean empty()
	{
		return front == null || back == null;
	}

	public void push_back(Type value)
	{
		if(this.empty())
		{
			this.front = this.back = new Element<Type>(value);
			return;
		}

		this.back.next = this.back = new Element<Type>(value, this.back);
	}

	public Type pop_back()
	{
		if(this.empty())
			return null;

		Type result = this.back.value;
		back = back.prev;
		if(back != null)
			back.next = null;

		return result;
	}

	public void push_front(Type value)
	{
		if(this.empty())
		{
			this.front = this.back = new Element<Type>(value);
			return;
		}

		this.front.prev = this.front = new Element<Type>(value, null, this.front);
	}

	public Type pop_front()
	{
		if(this.empty())
			return null;

		Type result = this.front.value;
		front = front.next;
		if(front != null)
			front.prev = null;

		return result;
	}
}

public class Zadanie1
{
	public static void main(String args[])
	{
		List<Integer> list = new List<Integer>();
		list.push_back(25);
		list.push_back(75);
		list.push_back(100);
		FileOutputStream file = null;
		ObjectOutputStream out = null;
		try
		{
			file = new FileOutputStream("list.dat");
			out = new ObjectOutputStream(file);
			out.writeObject(list);
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
		
		List input = null;
		FileInputStream file2 = null;
		ObjectInputStream in = null;
		try
		{
			file2 = new FileInputStream("list.dat");
			in = new ObjectInputStream(file2);
			input = (List) in.readObject();

		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		finally 
		{
			try {if (in != null) in.close();}
			catch (IOException e) {}

			try {if (file2 != null) file2.close();}
			catch (IOException e) {}
		}

		System.out.println(input.empty());
		System.out.println(input.pop_front());
		System.out.println(input.pop_back());
		System.out.println(input.pop_back());
		System.out.println(input.empty());
	}
}
