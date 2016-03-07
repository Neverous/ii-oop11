class Element<Type>
{
	public Type value;
	public Element<Type> prev,
	                     next;

	public Element(Type value, Element<Type> prev = null, Element<Type> next = null)
	{
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
}

public class Lista<Type>
{
	private Element<Type> front,
	                      back;

	public bool empty()
	{
		return front == null || back == null;
	}

	public void push_back(Type value)
	{
		if(this.empty())
		{
			front = back = new Element<Type>(value);
			return;
		}

		this.back.next = this.back = new Element<Type>(value, this.back);
	}

	public Type pop_back()
	{
		if(this.empty())
			return default(Type);

		Type result = back.value;
		back = back.prev;
		if(back != null)
			back.next = null;

		return result;
	}

	public void push_front(Type value)
	{
		if(this.empty())
		{
			front = back = new Element<Type>(value);
			return;
		}

		this.front.prev = this.front = new Element<Type>(value, null, this.front);
	}

	public Type pop_front()
	{
		if(this.empty())
			return default(Type);

		Type result = front.value;
		front = front.next;
		if(front != null)
			front.prev = null;

		return result;
	}
}
