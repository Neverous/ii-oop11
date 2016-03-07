import java.util.Arrays;
class ThreadedMergeSortWorker extends Thread
{
	Integer[] array;
	int start,
		end;

	ThreadedMergeSortWorker(Integer[] array, int start, int end)
	{
		this.array = array;
		this.start = start;
		this.end = end;
	}

	public void run()
	{
		if(end - start <= 1)
			return;

		int middle = (end + start) / 2;
		ThreadedMergeSortWorker left = new ThreadedMergeSortWorker(array, start, middle),
								right = new ThreadedMergeSortWorker(array, middle, end);

		try
		{
			left.start();
			right.start();
			left.join();
			right.join();
		}
		catch(InterruptedException err)
		{
			System.out.println(err);
			return;
		}

		Integer[] temp = new Integer[end - start];
		int t = 0,
			a = start,
			b = middle;
		while(a < middle && b < end)
		{
			if(array[a] < array[b])
				temp[t ++] = array[a ++];

			else
				temp[t ++] = array[b ++];
		}

		while(a < middle)
			temp[t ++] = array[a ++];

		while(b < end)
			temp[t ++] = array[b ++];

		for(t = 0; t < end - start; ++ t)
			array[start + t] = temp[t];
	}
}
class ThreadedMergeSort
{
	public void sort(Integer[] array)
	{
		ThreadedMergeSortWorker worker = new ThreadedMergeSortWorker(array, 0, array.length);
		try
		{
			worker.start();
			worker.join();
		}
		catch(InterruptedException err)
		{
			System.out.println(err);
			return;
		}
	}
}

public class Zadanie5
{
	public static void main(String args[])
	{
		ThreadedMergeSort sort = new ThreadedMergeSort();
		Integer[] array = new Integer[200];
		for(int n = 0; n < 200; ++ n)
			array[n] = (int)Math.floor(Math.random() * 100);

		System.out.println(Arrays.toString(array));
		sort.sort(array);
		System.out.println(Arrays.toString(array));

		Integer[] array2 = new Integer[2000];
		for(int n = 0; n < 2000; ++ n)
			array2[n] = (int)Math.floor(Math.random() * 1000);

		System.out.println("Zaczynam sortować");
		sort.sort(array2);
		System.out.println("Posortowałem");
	}
}
