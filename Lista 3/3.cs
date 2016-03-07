using System;
public sealed class AlmostSingleton
{
	private static int MaxInstances = 5;
	private static int ActualInstance = 0;
	private static AlmostSingleton[] Instances = new AlmostSingleton[MaxInstances];

	private AlmostSingleton() {}
	public string nazwa;

	public static AlmostSingleton Instance()
	{
		if(ActualInstance == MaxInstances)
			ActualInstance = 0;

		if(Instances[ActualInstance] == null)
			Instances[ActualInstance] = new AlmostSingleton();

		return Instances[ActualInstance ++];
	}
}
