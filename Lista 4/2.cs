using System;

class EmptyBufferException: Exception
{
	public EmptyBufferException(string message) {}
}

class Buffer<Type>
{
	private Type[] elements;
	private int size = 0,
	            maxsize = 0,
				start = 0,
				end = 0;
	public Buffer(int size)
	{
		this.elements = new Type[size];
		this.maxsize = size;
	}

	public static bool operator+(Buffer<Type> buffer, Type element)
	{
		if(buffer.size == buffer.maxsize)
			return false;

		buffer.elements[buffer.end] = element;
		buffer.end = (buffer.end + 1) % buffer.maxsize;
		++ buffer.size;
		return true;
	}

	public Type Last
	{
		get
		{
			if(this.size == 0)
				throw new EmptyBufferException("Buffer is empty!");

			-- this.size;
			Type val = this.elements[this.start];
			this.start = (this.start + 1) % this.maxsize;
			return val;
		}
	}
}

public class Example
{
	public static void Main()
	{
		Buffer<int> buffer = new Buffer<int>(3);
		if(buffer + 5)
			Console.WriteLine("+5 OK");

		if(buffer + 7)
			Console.WriteLine("+7 OK");

		if(buffer + 2)
			Console.WriteLine("+2 OK");

		if(!(buffer + 9887))
			Console.WriteLine("!+x OK");

		Console.WriteLine(buffer.Last);
		if(buffer + 2)
			Console.WriteLine("+2 OK");

		Console.WriteLine(buffer.Last);
		Console.WriteLine(buffer.Last);
		Console.WriteLine(buffer.Last);
		try
		{
			Console.WriteLine(buffer.Last);
		}
		catch(EmptyBufferException)
		{
			Console.WriteLine("Exception OK");
		}
	}
}
